package org.abhi.test;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Z001TestStreams008 {
	public static void main(String[] args) throws IOException {
		try (Stream<String> linesStream = Files.lines(Paths.get("sample.txt")).filter(s -> s.contains("is"))) {
			linesStream.forEach(System.out::println);
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
		}

		System.out.println("--------------");

		try (Stream<String> linesStream1 = Files.lines(Paths.get("sample.txt")).filter(s -> s.contains("is"))) {
			System.out.println(linesStream1.findFirst().get());
		} catch (Exception e) {
			// TODO: handle exception
		}

	}
}
