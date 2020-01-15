package kr.latera.feigndemo;

import java.util.List;

public class HttpBinJsonResponse {
    private SlideshowResponse slideshow;

    public SlideshowResponse getSlideshow() {
        return slideshow;
    }

    @Override
    public String toString() {
        return "HttpBinJsonResponse{" +
                "slideshow=" + slideshow +
                '}';
    }

    public class SlideshowResponse {
        private String author;
        private String date;
        private List<SlideResponse> slides;

        public String getAuthor() {
            return author;
        }

        public String getDate() {
            return date;
        }

        public List<SlideResponse> getSlides() {
            return slides;
        }

        @Override
        public String toString() {
            return "SlideshowResponse{" +
                    "author='" + author + '\'' +
                    ", date='" + date + '\'' +
                    ", slides=" + slides +
                    '}';
        }

        public class SlideResponse {
            private String title;
            private String type;
            private List<String> items;

            @Override
            public String toString() {
                return "SlideResponse{" +
                        "title='" + title + '\'' +
                        ", type='" + type + '\'' +
                        ", items=" + items +
                        '}';
            }

            public String getTitle() {
                return title;
            }

            public String getType() {
                return type;
            }

            public List<String> getItems() {
                return items;
            }
        }
    }
}
