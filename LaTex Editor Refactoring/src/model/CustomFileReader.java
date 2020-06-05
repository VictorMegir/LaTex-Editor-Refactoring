package model;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;

public class CustomFileReader
{
	public ArrayList<String> readLineByLine(String filePath) 
    {
        ArrayList<String> stringItems = new ArrayList<String>();
        try (Stream<String> stream = Files.lines( Paths.get(filePath), StandardCharsets.UTF_8)) 
        {
        	stream.forEach(s -> stringItems.add(s));
        }
        catch (IOException e) 
        {
            e.printStackTrace();
        }
        return stringItems;
    }
	
	public String readFileAsString(String filePath)
	{
		StringBuilder contentBuilder = new StringBuilder();
	    try (Stream<String> stream = Files.lines( Paths.get(filePath), StandardCharsets.UTF_8)) 
        {
        	stream.forEach(s -> contentBuilder.append(s).append("\n"));
        }
        catch (IOException e) 
        {
            e.printStackTrace();
        }
	    return contentBuilder.toString();
	}
	
	public String getPathToAssets()
	{
		Path path = Paths.get("src/Assets");
		Path real = null;
		try
		{
			real = path.toRealPath(LinkOption.NOFOLLOW_LINKS);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return real.toString();
	}
}