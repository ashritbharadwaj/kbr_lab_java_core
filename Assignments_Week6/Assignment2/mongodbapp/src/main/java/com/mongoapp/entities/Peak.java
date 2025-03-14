package com.mongoapp.entities;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Map;

@Document(collection = "peaks")
public class Peak {
    private String id;
    private String name;
    private int height;
    private List<String> location;
    private Ascents ascents;

    public Peak(String name, int height, List<String> location, Ascents ascents) {
        this.name = name;
        this.height = height;
        this.location = location;
        this.ascents = ascents;
    }

    public static class Ascents {
        private FirstAscent first;
        private FirstAscent firstWinter;
        private int total;

        public Ascents(FirstAscent first, FirstAscent firstWinter, int total) {
            this.first = first;
            this.firstWinter = firstWinter;
            this.total = total;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("Ascents{");
            sb.append("first=").append(first);
            sb.append(", firstWinter=").append(firstWinter);
            sb.append(", total=").append(total);
            sb.append('}');
            return sb.toString();
        }

        public static class FirstAscent {
            private int year;

            @Override
            public String toString() {
                final StringBuilder sb = new StringBuilder("FirstAscent{");
                sb.append("year=").append(year);
                sb.append('}');
                return sb.toString();
            }

            public FirstAscent(int year) {
                this.year = year;
            }

            // Getters and setters
            public int getYear() {
                return year;
            }

            public void setYear(int year) {
                this.year = year;
            }
        }

        // Getters and setters
        public FirstAscent getFirst() {
            return first;
        }

        public void setFirst(FirstAscent first) {
            this.first = first;
        }

        public FirstAscent getFirstWinter() {
            return firstWinter;
        }

        public void setFirstWinter(FirstAscent firstWinter) {
            this.firstWinter = firstWinter;
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }
    }

    // Getters and setters
    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Peak{");
        sb.append("id='").append(id).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", height=").append(height);
        sb.append(", location=").append(location);
        sb.append(", ascents=").append(ascents);
        sb.append('}');
        return sb.toString();
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public List<String> getLocation() {
        return location;
    }

    public void setLocation(List<String> location) {
        this.location = location;
    }

    public Ascents getAscents() {
        return ascents;
    }

    public void setAscents(Ascents ascents) {
        this.ascents = ascents;
    }
}
