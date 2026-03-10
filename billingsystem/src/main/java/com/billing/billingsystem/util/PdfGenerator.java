package com.billing.billingsystem.util;

import java.io.File;
import java.time.LocalDateTime;
import java.util.List;

import com.billing.billingsystem.entity.BillItem;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.TextAlignment;

public class PdfGenerator {

    public static void generateBillPdf(String customerName, double totalAmount, List<BillItem> items) {

        try {

            String folderPath = "C:/bills/";

            File folder = new File(folderPath);
            if (!folder.exists()) {
                folder.mkdirs();
            }

            String filePath = folderPath + "bill_" + System.currentTimeMillis() + ".pdf";

            PdfWriter writer = new PdfWriter(filePath);
            PdfDocument pdf = new PdfDocument(writer);
            Document document = new Document(pdf);

            // Store Header
            Paragraph storeName = new Paragraph("ADITYA SUPERMART")
                    .setBold()
                    .setFontSize(18)
                    .setTextAlignment(TextAlignment.CENTER);

            document.add(storeName);
            document.add(new Paragraph("GSTIN: 22ABCDE1234F1Z5")
                    .setTextAlignment(TextAlignment.CENTER));

            document.add(new Paragraph("--------------------------------------------"));

            // Customer Info
            document.add(new Paragraph("Customer : " + customerName));
            document.add(new Paragraph("Date : " + LocalDateTime.now()));
            document.add(new Paragraph(" "));

            // Table Layout
            float[] columnWidths = {200F, 80F, 100F, 100F};
            Table table = new Table(columnWidths);

            table.addCell("Product");
            table.addCell("Qty");
            table.addCell("Price");
            table.addCell("Total");

            double subtotal = 0;

            for (BillItem item : items) {

                double itemTotal = item.getPrice() * item.getQuantity();
                subtotal += itemTotal;

                table.addCell(item.getProductName());
                table.addCell(String.valueOf(item.getQuantity()));
                table.addCell("₹" + item.getPrice());
                table.addCell("₹" + itemTotal);
            }

            document.add(table);

            document.add(new Paragraph("--------------------------------------------"));

            double gst = subtotal * 0.05;
            double grandTotal = subtotal + gst;

            document.add(new Paragraph("Subtotal : ₹" + subtotal));
            document.add(new Paragraph("GST (5%) : ₹" + gst));
            document.add(new Paragraph("Grand Total : ₹" + grandTotal).setBold());

            document.add(new Paragraph("--------------------------------------------"));
            document.add(new Paragraph("Thank You Visit Again!")
                    .setTextAlignment(TextAlignment.CENTER));

            document.close();

            System.out.println("PDF Bill Generated: " + filePath);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}