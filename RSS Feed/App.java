package vmm;

import java.net.URL;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.FeedException;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class App
{
    public SyndFeed writenews(String url) throws FeedException
        {
            SyndFeed feed = null;
        try 
        {
            URL feedUrl = new URL(url);
            SyndFeedInput input = new SyndFeedInput();
            feed = input.build(new XmlReader(feedUrl));
            //String s = ((List<SyndEntry>)feed.getEntries()).get(0).getDescription().getValue();
        } 
        catch (MalformedURLException ex) 
        {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
        return feed;
        }
        
                
    
}