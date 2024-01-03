package com.fsts.gestion_factures.controller;

import com.fsts.gestion_factures.model.request.FactureRequest;
import com.fsts.gestion_factures.model.request.LigneCommandeRequest;
import com.fsts.gestion_factures.model.response.*;
import com.fsts.gestion_factures.service.FactureService;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class FactureController {
    private final FactureService factureService;
    @PostMapping("/add-facture")
    public ResponseEntity<FactureResponse> addFacture(@RequestBody FactureRequest request){
        return  new ResponseEntity<>(factureService.add(request), HttpStatus.CREATED);
    }
    @GetMapping("/get-all-facture")
    public  ResponseEntity<List<FactureResponse>> getAllLigneCommande(){
        return  new ResponseEntity<>(factureService.get(),HttpStatus.OK);
    }
    @GetMapping("/get-facture/{id}")
    public ResponseEntity<FactureResponse> getUser(@PathVariable Long id){
        return new ResponseEntity<>(factureService.get(id),HttpStatus.OK);
    }

    @PutMapping("update-facture/{id}")
    public ResponseEntity<FactureResponse> updateLigneCommande(@RequestBody FactureRequest request, @PathVariable Long id){
        return  new ResponseEntity<>(factureService.update(request,id),HttpStatus.OK);
    }
    @GetMapping("/get-history/{id}")
    public ResponseEntity<List<HistoriqueFactureResponse>> afficheageHistooriqueFacture(@PathVariable Long id){
        return  new ResponseEntity<>(factureService.getHistoriqueFacture(id),HttpStatus.OK);
    }
    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy - HH:mm:ss");
    public String currentDate = dateFormat.format(new Date());

    @GetMapping("/factures/export/pdf")
    public void exportFacturesPDF(HttpServletResponse response) throws IOException, DocumentException {
        List<FactureResponse> factures = factureService.get();
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=\"Factures " + currentDate + ".pdf\"");

        Document document = new Document();
        PdfWriter.getInstance(document, response.getOutputStream());
        document.open();

        // Title
        Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18, BaseColor.BLACK);
        Paragraph title = new Paragraph("Factures", titleFont);
        title.setAlignment(Element.ALIGN_CENTER);
        document.add(title);

        // Empty Line
        document.add(Chunk.NEWLINE);

        PdfPTable table = new PdfPTable(5); // Adjust the number of columns as per your requirement

        table.setWidthPercentage(100);

        table.addCell("Date");
        table.addCell("Montant");
        table.addCell("Etat Facture");
        table.addCell("Commande");
        table.addCell("Paiements");

//        for (FactureResponse facture : factures) {
//            table.addCell(String.valueOf(facture.getDateFacture()));
//            table.addCell(String.valueOf(facture.getMontant()));
//            table.addCell(String.valueOf(facture.getEtatFacture()));
//            table.addCell(String.valueOf(facture.getCommande()));
//            table.addCell(String.valueOf(facture.getPaiements()));
//        }
        for (FactureResponse facture : factures) {
            table.addCell(String.valueOf(facture.getDateFacture()));
            table.addCell(String.valueOf(facture.getMontant()));
            table.addCell(String.valueOf(facture.getEtatFacture()));
            table.addCell(String.valueOf(facture.getCommande()));

            // Iterate over Paiements and add relevant information to the cell
            PdfPCell paiementsCell = new PdfPCell();
            for (PaiementResponse paiement : facture.getPaiements()) {
                paiementsCell.addElement(new Paragraph("Montant: " + paiement.getMontant()));
                paiementsCell.addElement(new Paragraph("Mode Paiement: " + paiement.getModePaiement()));
                // Add more details as needed
            }
            table.addCell(paiementsCell);
            document.add(table);
            document.close();
        }
    }

}
