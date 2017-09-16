
import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.FeedException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import vmm.App;

public class fetch_rss
{

    public static void main(String[] args)
    {
        try
        {
            String s = "http://feeds.feedburner.com/ndtvsports-cricket";
            App app = new App();
            SyndFeed feed = app.writenews(s);

            List<SyndEntry> list1 = (List<SyndEntry>) feed.getEntries();
            for (int i = 0; i < list1.size(); i++)
            {
                String title = list1.get(i).getTitle();
                String link = list1.get(i).getLink();
                String actualdesc = "";

                System.out.println(title);
                System.out.println(link);
//
//                String desc = list1.get(i).getDescription().getValue();
//                System.out.println(desc);
//                if (desc.contains("<br"))
//                {
//                    int indexofbr = desc.indexOf("<br");
//                    String desc1 = desc.substring(1, indexofbr);
//                    actualdesc = desc1.trim();
////                    System.out.println(desc.substring(indexofbr));
//                }
//                if (!actualdesc.contains("<br"))
//                {
////                    System.out.println(desc);
//                }
//
//                String author = list1.get(i).getAuthor();

                System.out.println("*************************************");
            }

        } catch (Exception ex)
        {
            Logger.getLogger(fetch_rss.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
