package ir.plusteam.media;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by Ali on 5/22/2017.
 */

public class MyIO {
    /**
     * it will returns sd path for you
     *  <p>
     *  <b>Required Permission: </b>android.permission.READ_EXTERNAL_STORAGE<br/>
     * </p>
     * @return
     */
    public  List<String> GetExternalMounts() {
        final List<String> out = new ArrayList<>();
        String reg = "(?i).*vold.*(vfat|ntfs|exfat|fat32|ext3|ext4).*rw.*";
        String s = "";
        try {
            final Process process = new ProcessBuilder().command("mount")
                    .redirectErrorStream(true).start();
            process.waitFor();
            final InputStream is = process.getInputStream();
            final byte[] buffer = new byte[1024];
            while (is.read(buffer) != -1) {
                s = s + new String(buffer);
            }
            is.close();
        } catch (final Exception e) {
            e.printStackTrace();
        }

        // parse output
        final String[] lines = s.split("\n");
        for (String line : lines) {
            if (!line.toLowerCase(Locale.US).contains("asec")) {
                if (line.matches(reg)) {
                    String[] parts = line.split(" ");
                    for (String part : parts) {
                        if (part.startsWith("/"))
                            if (!part.toLowerCase(Locale.US).contains("vold"))
                                if(new File(part).canWrite())
                                    out.add(part);
                    }
                }
            }
        }
        return out;
    }
}
