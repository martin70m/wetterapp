package martin70m.common.io;

import java.io.File;

public class FileFinder {
	public static String find(String pattern, String pathDir) {
		
        File file = new File(pathDir);
        if(file.isDirectory()) {
        	File[] files = file.listFiles();
        	if(files != null)
				for(File f : files)
					if(f.getName().contains(pattern))
						return f.getName();

        }
		return "";
	}
}
