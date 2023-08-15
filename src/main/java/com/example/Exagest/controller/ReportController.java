package com.example.Exagest.controller;


import com.example.Exagest.entities.ConvertierMontantEnLettre;
import com.example.Exagest.entities.Moyenne;
import com.example.Exagest.entities.Note;
import com.example.Exagest.repository.AnneeRepository;
import com.example.Exagest.repository.MoyenneRepository;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

import static com.example.Exagest.security.utils.constants.JavaConstant.API_BASE_URL;

@RestController
@RequestMapping(path = API_BASE_URL+"report/")
@CrossOrigin("*")
@RequiredArgsConstructor
public class ReportController {

    private final MoyenneRepository moyenneRepository;
    private final AnneeRepository anneeRepository;

    @Value("${images.dir}")
    private String reportDir;


    public Double convert(Double d) {

        DecimalFormat df = new DecimalFormat("#,00");
        df.setMaximumFractionDigits(2); // arrondi à 2 chiffres apres la
        // virgules
        df.setMinimumFractionDigits(2);
        String str = df.format(d);
        // df.setDecimalSeparatorAlwaysShown ( true ) ;
        d = Double.parseDouble(str.replace(',', '.'));

        return d;
    }

    @RequestMapping(value = "recapitulatif/{idExam}/{idSection}", method = RequestMethod.GET)
    public void reportListe(HttpServletResponse response,
                            @PathVariable("idExam") Long idExam,  @PathVariable("idSection") Long idSection) throws Exception{
        response.setContentType("text/html");


        List<Moyenne> operations = moyenneRepository.listMoyenneExamOudalReport(idExam,idSection);

        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(null);
        Vector collection = new Vector();

        for ( Moyenne p : operations
        ) {
            HashMap<String,Object> param = new HashMap<>();

            param.put("nom",p.getInscription().getEleve().getNom());
            param.put("prenom", p.getInscription().getEleve().getPrenom());
            param.put("moyenne",convert(p.getMoyenneTotale()));
            param.put("rang",p.getRangGenerale());
            param.put("ecole",p.getInscription().getEcole().getNomEcole());
            param.put("session",p.getSession().getLibele());
            param.put("examen",p.getExamen().getLibele());

            collection.add(param);
        }
        dataSource = new JRBeanCollectionDataSource(collection);

        InputStream jrxmlInput = new FileInputStream(new File(reportDir+"report_recapitulatif.jrxml"));

        JasperDesign design = JRXmlLoader.load(jrxmlInput);
        JasperReport jasperReport = JasperCompileManager.compileReport(design);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,null,dataSource);

        JRPdfExporter pdfExporter = new JRPdfExporter();
        pdfExporter.setExporterInput(new SimpleExporterInput(jasperPrint));
        ByteArrayOutputStream pdfReportStream = new ByteArrayOutputStream();
        pdfExporter.setExporterOutput(new SimpleOutputStreamExporterOutput(pdfReportStream));
        pdfExporter.exportReport();

        response.setContentType("application/pdf");
        response.setHeader("Content-Length", String.valueOf(pdfReportStream.size()));
        response.addHeader("Content-Disposition", "inline; filename=jasper.pdf;");

        OutputStream responseOutputStream = response.getOutputStream();
        responseOutputStream.write(pdfReportStream.toByteArray());
        responseOutputStream.close();
        pdfReportStream.close();
    }




    @RequestMapping(value = "recapitulatif-Ecole/{idExam}/{idSection}/{idEcole}", method = RequestMethod.GET)
    public void reportEcole(HttpServletResponse response,
                            @PathVariable("idExam") Long idExam,  @PathVariable("idSection") Long idSection,  @PathVariable("idEcole") Long idEcole) throws Exception{
        response.setContentType("text/html");


        List<Moyenne> operations = moyenneRepository.listMoyenneExamOudalReportEcole(idExam,idSection,idEcole);

        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(null);
        Vector collection = new Vector();

        for ( Moyenne p : operations
        ) {
            HashMap<String,Object> param = new HashMap<>();

            param.put("nom",p.getInscription().getEleve().getNom());
            param.put("prenom", p.getInscription().getEleve().getPrenom());
            param.put("moyenne",convert(p.getMoyenneTotale()));
            param.put("rangGeneral",p.getRangGenerale());
            param.put("rangEcole",p.getRangEcole());
            param.put("ecole",p.getInscription().getEcole().getNomEcole());
            param.put("session",p.getSession().getLibele());
            param.put("examen",p.getExamen().getLibele());

            collection.add(param);
        }
        dataSource = new JRBeanCollectionDataSource(collection);


        InputStream jrxmlInput = new FileInputStream(new File(reportDir+"report_recapitulatif_ecole.jrxml"));

        JasperDesign design = JRXmlLoader.load(jrxmlInput);
        JasperReport jasperReport = JasperCompileManager.compileReport(design);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,null,dataSource);

        JRPdfExporter pdfExporter = new JRPdfExporter();
        pdfExporter.setExporterInput(new SimpleExporterInput(jasperPrint));
        ByteArrayOutputStream pdfReportStream = new ByteArrayOutputStream();
        pdfExporter.setExporterOutput(new SimpleOutputStreamExporterOutput(pdfReportStream));
        pdfExporter.exportReport();

        response.setContentType("application/pdf");
        response.setHeader("Content-Length", String.valueOf(pdfReportStream.size()));
        response.addHeader("Content-Disposition", "inline; filename=jasper.pdf;");

        OutputStream responseOutputStream = response.getOutputStream();
        responseOutputStream.write(pdfReportStream.toByteArray());
        responseOutputStream.close();
        pdfReportStream.close();
    }


    @RequestMapping(value = "releve/{idExam}/{idSection}", method = RequestMethod.GET)
    public void reportEcole(HttpServletResponse response,
                            @PathVariable("idExam") Long idExam,  @PathVariable("idSection") Long idSection) throws Exception{
        response.setContentType("text/html");

        System.out.println("-----------------------");
        List<Note> operations = moyenneRepository.relever(idExam,idSection);
        System.out.println("-----fffffffffff------------------");
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(null);
        Vector collection = new Vector();

        for ( Note p : operations
        ) {
            HashMap<String,Object> param = new HashMap<>();

            param.put("nom",p.getInscription().getEleve().getNom());
            param.put("prenom", p.getInscription().getEleve().getPrenom());
            param.put("numeroJury", p.getInscription().getId());
            param.put("note",p.getNoteExam());
            param.put("coef", Double.valueOf(p.getAttributionMatiere().getCoefficient()) );
            param.put("noteCoef",Double.valueOf(p.getAttributionMatiere().getCoefficient()*p.getNoteExam()));
            param.put("noteSur",Double.valueOf(p.getAttributionMatiere().getCoefficient()*20));
            param.put("matiere",p.getAttributionMatiere().getMatiere().getLibele());
            param.put("type",p.getAttributionMatiere().getMatiere().getTypeMat().getLibele());
            param.put("code",p.getAttributionMatiere().getMatiere().getCodeMat());

            ConvertierMontantEnLettre v = new ConvertierMontantEnLettre();

            String result = String.valueOf(convert(moyenneRepository.findByInscrit(p.getInscription(),idSection)));

            v.setMontant(result);
            v.calculer_glob();

            param.put("lettre", v.getMontantLettre());
            param.put("logo",reportDir);
            param.put("logobk",reportDir);
            param.put("moyenne",convert(moyenneRepository.findByInscrit(p.getInscription(),idSection)));
            param.put("session",p.getSession().getLibele());
            param.put("mention",moyenneRepository.findByInscrit2(p.getInscription(),idSection).getMention());
            param.put("examen",p.getExamen().getLibele());

            collection.add(param);
        }
        dataSource = new JRBeanCollectionDataSource(collection);

        InputStream jrxmlInput = new FileInputStream(new File(reportDir+"report_releve.jrxml"));

        JasperDesign design = JRXmlLoader.load(jrxmlInput);
        JasperReport jasperReport = JasperCompileManager.compileReport(design);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,null,dataSource);

        JRPdfExporter pdfExporter = new JRPdfExporter();
        pdfExporter.setExporterInput(new SimpleExporterInput(jasperPrint));
        ByteArrayOutputStream pdfReportStream = new ByteArrayOutputStream();
        pdfExporter.setExporterOutput(new SimpleOutputStreamExporterOutput(pdfReportStream));
        pdfExporter.exportReport();

        response.setContentType("application/pdf");
        response.setHeader("Content-Length", String.valueOf(pdfReportStream.size()));
        response.addHeader("Content-Disposition", "inline; filename=jasper.pdf;");

        OutputStream responseOutputStream = response.getOutputStream();
        responseOutputStream.write(pdfReportStream.toByteArray());
        responseOutputStream.close();
        pdfReportStream.close();
    }
}
