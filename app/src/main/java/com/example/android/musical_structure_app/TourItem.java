
package com.example.android.musical_structure_app;

/**
 * {@link TourItem} represents a song that the user wants to listen.
 * It contains a song title, artist, and an image for that song.
 */
public class TourItem {

    /** Default title for the TourItem */
    private String mTitle;

    /** Artist for the TourItem */
    private String mDescription;

    /** Image resource ID for the TourItem */
    private int mImageResourceId = NO_IMAGE_PROVIDED;

    /** Constant value that represents no image was provided for this TourItem */
    private static final int NO_IMAGE_PROVIDED = -1;

    /**
     * Create a new TourItem object.
     *
     * @param title is the title for the TourItem
     * @param description is a description of the TourItem
     */
    public TourItem(String title, String description) {
        mTitle = title;
        mDescription = description;
    }

    /**
     * Create a new TourItem object.
     *
     * @param title is the title for the TourItem
     * @param description is a description of the TourItem
     * @param imageResourceId is the drawable resource ID associated with the TourItem
     *
     */
    public TourItem(String title, String description, int imageResourceId) {
        mTitle = title;
        mDescription = description;
        mImageResourceId = imageResourceId;
    }

    /**
     * Get the title of the TourItem.
     */
    public String getTitle() {
        return mTitle;
    }

    /**
     * Get the description of the TourItem.
     */
    public String getDescription() {
        return mDescription;
    }

    /**
     * Return the image resource ID of the TourItem.
     */
    public int getImageResourceId() {
        return mImageResourceId;
    }

    /**
     * Returns whether or not there is an image for this TourItem.
     */
    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }
}