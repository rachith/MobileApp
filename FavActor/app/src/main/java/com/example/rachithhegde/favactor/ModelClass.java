package com.example.rachithhegde.favactor;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ModelClass {



        @SerializedName("imageUrl")
        @Expose
        private String imageUrl;
        @SerializedName("actorName")
        @Expose
        private String actorName;
        @SerializedName("movies")
        @Expose
        private String movies;

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }

        public String getActorName() {
            return actorName;
        }

        public void setActorName(String actorName) {
            this.actorName = actorName;
        }

        public String getMovies() {
            return movies;
        }

        public void setMovies(String movies) {
            this.movies = movies;
        }


}
