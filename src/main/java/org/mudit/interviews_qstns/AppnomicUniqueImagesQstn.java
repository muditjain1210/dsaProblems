package org.mudit.interviews_qstns;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class AppnomicUniqueImagesQstn {

    public static void printImages(Set<Image> images) {
        for (Image image : images) {
            System.out.println(image);
        }
    }

    public static void main(String[] args) {
        Image[] images = {new Image("flag.jpg", 40, 60),
                new Image("flag.gif", 40, 60),
                new Image("smile.gif", 100, 200),
                new Image("smile.gif", 50, 400),
                new Image("other.jpg", 40, 60),
                new Image("lenna.jpg", 512, 512),
                new Image("Lenna.jpg", 512, 512)};

        Set<Image> set = new HashSet<Image>(Arrays.asList(images));
        AppnomicUniqueImagesQstn.printImages(set);
    }

    static class Image {
        private final String filename;
        private final int width;
        private final int height;

        public Image(String filename, int width, int height) {
            this.filename = filename;
            this.width = width;
            this.height = height;
        }

        // We need to implement hashcode..because hashcode check is done before equals test..
        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            String filenameU = filename.split("\\.")[0];
            result = prime * result + ((filenameU == null) ? 0 : filenameU.hashCode());
            result = prime * result * height;
            result = prime * result * width;
            return result;
        }

        /**
         * Two Images are considered equal if they have
         * the same filename (without the extension), and the
         * same number of pixels.
         * Thus, flag.jpg with width=60 height=40 is
         * equal to flag.gif with width=40 and height=60
         */
        @Override
        public boolean equals(Object other) {
            Image o = (Image) other;
            if (filename == null || o.filename == null)
                return false;
            String[] components = filename.split("\\.");
            String[] ocomponents = o.filename.split("\\.");
            return components[0].equals(ocomponents[0]) &&
                    (width * height == o.width * o.height);
        }

        @Override
        public String toString() {
            return "Image: filename=" + filename + " Size=" + width * height;
        }
    }
}
