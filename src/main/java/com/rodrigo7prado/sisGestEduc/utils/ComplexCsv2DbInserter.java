package com.rodrigo7prado.sisGestEduc.utils;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import org.supercsv.cellprocessor.Optional;
import org.supercsv.cellprocessor.ParseDouble;
import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvBeanReader;
import org.supercsv.io.ICsvBeanReader;
import org.supercsv.prefs.CsvPreference;

public class ComplexCsv2DbInserter {

//	private String jdbcURL = "jdbc:mysql://localhost:3306/sales?useTimezone=true&serverTimezone=UTC";
	private String jdbcURL = "jdbc:mysql://localhost:3306/sisgesteduc?useTimezone=true&serverTimezone=UTC";
	private String username = "root";
	private String password = "";

	private String csvFilePath = "Reviews-complex.csv";
	private Connection connection = null;

	ICsvBeanReader beanReader = null;
	CellProcessor[] processors = new CellProcessor[] { new NotNull(), // course name
			new NotNull(), // student name
			new ParseTimestamp(), // timestamp
			new ParseDouble(), // rating
			new Optional()// comment
	};

	public ComplexCsv2DbInserter() {
		int batchSize = 20;
		try {
			long start = System.currentTimeMillis();

			connection = DriverManager.getConnection(jdbcURL, username, password);
			connection.setAutoCommit(false);

			String sql = "INSERT INTO review (course_named, student_name, timestamp, rating, comment) VALUES (?, ?, ?, ?, ?)";
			PreparedStatement statement = connection.prepareStatement(sql);

			beanReader = new CsvBeanReader(new FileReader(csvFilePath), CsvPreference.STANDARD_PREFERENCE);

			beanReader.getHeader(true); // skip header line

			String[] header = { "courseName", "studentName", "timestamp", "rating", "comment" };
			Review bean = null;

			int count = 0;

			while ((bean = beanReader.read(Review.class, header, processors)) != null) {
				String courseName = bean.getCourseName();
				String studentName = bean.getStudentName();
				Timestamp timestamp = bean.getTimestamp();
				double rating = bean.getRating();
				String comment = bean.getComment();

				statement.setString(1, courseName);
				statement.setString(2, studentName);
				statement.setTimestamp(3, timestamp);
				statement.setDouble(4, rating);
				statement.setString(5, comment);
				statement.addBatch();

				if (count % batchSize == 0) {
					statement.executeBatch();
				}
			}

			beanReader.close();

			// execute the remaining queries
			statement.executeBatch();

			connection.commit();
			connection.close();

			long end = System.currentTimeMillis();
			System.out.println("Execution Time: " + (end - start));
		} catch (IOException ex) {
			System.err.println(ex);
		} catch (SQLException ex) {
			ex.printStackTrace();

			try {
				connection.rollback();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
