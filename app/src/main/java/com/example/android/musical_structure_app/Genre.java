
package com.example.android.musical_structure_app;

/**
 * {@link Genre} represents a musical category.
 * It contains a gender name, and an image for that genre.
 */
public class Genre {
    /** Genre of the song */
    private String mGenre;

    /** Image resource ID for the genre */
    private int mImageResourceId = NO_IMAGE_PROVIDED;

    /** Constant value that represents no image was provided for this genre */
    private static final int NO_IMAGE_PROVIDED = -1;

    /**
     * Create a new TourItem object.
     *
     * @param genre is genre
     * @param imageId is the id of the category image
     */
    public Genre(String genre, int imageId) {
        mGenre = genre;
        mImageResourceId= imageId;
    }

    /**
     * Get the genre of the song.
     */
    public String getGenre() {
        return mGenre;
    }

    /**
     * Return the image resource ID of the genre.
     */
    public int getImageResourceId() {
        return mImageResourceId;
    }

    /**
     * Returns whether or not there is an image for this genre.
     */
    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }
}