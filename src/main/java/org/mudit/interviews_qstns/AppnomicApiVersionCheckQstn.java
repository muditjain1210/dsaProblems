package org.mudit.interviews_qstns;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeSet;

public class AppnomicApiVersionCheckQstn {
    public static void main(String[] args) {

        try {
            Scanner in = new Scanner(
                    new BufferedReader(new FileReader("input.txt")));

            HashMap<String, TreeSet<VersionApp>> map = new HashMap<String, TreeSet<VersionApp>>();
            while (in.hasNextLine()) {
                String line = in.nextLine();
                String[] tokens = line.split(",");
                String api = tokens[1];
                if (map.get(api) != null) {
                    TreeSet<VersionApp> set = map.get(api);
                    set.add(new VersionApp(tokens[2], tokens[0]));
                    map.put(api, set);
                } else {
                    TreeSet<VersionApp> set = new TreeSet<>();
                    set.add(new VersionApp(tokens[2], tokens[0]));
                    map.put(api, set);
                }
            }
            TreeSet<String> resultApps = new TreeSet<>();
            for (String api : map.keySet()) {
                // System.out.println(api + " " + map.get(api));

                TreeSet<VersionApp> set = map.get(api);
                if (set.size() == 1) {
                    // Reject APIs having only version
                    continue;
                }
                resultApps.add(set.first().getAppName());
            }

            PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter("output.txt")));
            for (String result : resultApps) {
                output.println(result);
            }
            output.close();
        } catch (IOException e) {
            System.out.println("IO error in input.txt or output.txt");
        }
    }

}

class VersionApp implements Comparable<Object> {

    private String version;
    private String appName;

    public VersionApp(String version, String appName) {

        this.version = version;
        this.appName = appName;
    }

    @Override
    public String toString() {
        return "VersionApp [version=" + version + ", appName=" + appName + "]";
    }

    @Override
    public int compareTo(Object o) {
        VersionApp va = (VersionApp) o;
        return this.version.compareTo(va.version);

    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }
}