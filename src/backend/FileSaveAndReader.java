package backend;


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class FileSaveAndReader {
	
	public void saveAnimalToFile(File f, List<FeedLog> FedL) {
		ObjectOutputStream out = null;
		try {
			out = new ObjectOutputStream(new BufferedOutputStream(
					new FileOutputStream(f)));
			out.writeObject(FedL);
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public List<FeedLog> readAnimalFromFile(File f) {
		ObjectInputStream in = null;
		List<FeedLog> m = null;
		
		try {
			in = new ObjectInputStream(new BufferedInputStream(
					new FileInputStream(f)));
			m = (List<FeedLog>) in.readObject();
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return m;
	}
}
