package com.psa.flights_reservation_app_5.utilities;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.psa.flights_reservation_app_5.entities.Passenger;
import com.psa.flights_reservation_app_5.entities.Reservation;
import org.springframework.stereotype.Component;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@Component
public class PDFGenerator {

	private static Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD);
	private static Font subFont = new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.BOLD);

	public void generateItinerary(Reservation reservation, String filePath) {
		Document document = new Document();
		try {
			PdfWriter.getInstance(document, new FileOutputStream(filePath));
			document.open();
			addTitleAndTable(document, "Flight Itinerary", generateTable(reservation));
			document.close();
		} catch (DocumentException | IOException e) {
			e.printStackTrace();
		}
	}

	private void addTitleAndTable(Document document, String title, PdfPTable table) throws DocumentException {
		Paragraph preface = new Paragraph();
		preface.add(new Paragraph(title, catFont));
		document.add(preface);
		document.add(Chunk.NEWLINE);
		document.add(table);
	}

	private PdfPTable generateTable(Reservation reservation) {
		PdfPTable table = new PdfPTable(2);
		PdfPCell cell;

		cell = new PdfPCell(new Phrase("Flight Details", subFont));
		cell.setColspan(2);
		table.addCell(cell);

		table.addCell("Departure City");
		table.addCell(reservation.getFlight().getDepartureCity());

		table.addCell("Arrival City");
		table.addCell(reservation.getFlight().getArrivalCity());

		table.addCell("Flight Number");
		table.addCell(reservation.getFlight().getFlightNumber());

		table.addCell("Operating Airline");
		table.addCell(reservation.getFlight().getOperationAirline());

		table.addCell("Departure Date");
		table.addCell(reservation.getFlight().getDateOfDeparture().toString());

		table.addCell("Departure Time");
		table.addCell(reservation.getFlight().getEstimatedDepartureTime().toString());

		cell = new PdfPCell(new Phrase("Passenger Details", subFont));
		cell.setColspan(2);
		table.addCell(cell);

		// Iterate through the list of passengers
		List<Passenger> passengers = reservation.getPassengers();
		for (Passenger passenger : passengers) {
			table.addCell("First Name");
			table.addCell(passenger.getFirstName());

			table.addCell("Last Name");
			table.addCell(passenger.getLastName());

			table.addCell("Middle Name");
			table.addCell(passenger.getMiddleName());

			table.addCell("Contact Number");
			table.addCell(passenger.getPhone());

			table.addCell("Email");
			table.addCell(passenger.getEmail());

			// Add an empty row between passenger details for better readability
			table.addCell("");
			table.addCell("");
		}

		return table;
	}
}
