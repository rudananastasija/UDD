package com.example.naucna.services;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.io.RandomAccessFile;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.stereotype.Service;


@Service
public class DocHandler {
	public String getText(String fileName) {
		File file = new File("folder/" +fileName);
		System.out.println(" filee je "+file.getAbsolutePath());
		System.out.println("velcina fajla je "+file.length());
		
		
		try {
			
			PDFParser parser = new PDFParser(new RandomAccessFile(file, "r"));
			parser.parse();
			PDFTextStripper stripper = new PDFTextStripper();
			String text = stripper.getText(parser.getPDDocument());
			System.out.println("tekst dokumenta je "+text);
			return text;
		} catch (IOException e) {
			System.out.println("Greksa u doc handler");
			System.out.println(e);
		}
		System.out.println("velcina fajla je sada "+file.length());
		
		return null;
	}

}
