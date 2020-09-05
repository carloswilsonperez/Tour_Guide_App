
package com.example.android.musical_structure_app;

/**
 * {@link Song} represents a song that the user wants to listen.
 * It contains a song title, artist, and an image for that song.
 */
public class Song {

    /** Default title for the song */
    private String mTitle;

    /** Artist for the song */
    private String mArtist;

    /** Image resource ID for the song */
    private int mImageResourceId = NO_IMAGE_PROVIDED;

    /** Constant value that represents no image was provided for this song */
    private static final int NO_IMAGE_PROVIDED = -1;

    /**
     * Create a new Song object.
     *
     * @param title is the title for the song to play
     * @param artist is the artist playing the song
     */
    public Song(String title, String artist) {
        mTitle = title;
        mArtist = artist;
    }

    /**
     * Create a new Song object.
     *
     * @param title is the title for the song to play
     * @param artist is the artist playing the song
     * @param imageResourceId is the drawable resource ID for the image associated with the song
     *
     */
    public Song(String title, String artist, int imageResourceId) {
        mTitle = title;
        mArtist = artist;
        mImageResourceId = imageResourceId;
    }

    /**
     * Get the title of the song.
     */
    public String getTitle() {
        return mTitle;
    }

    /**
     * Get the artist playing the song.
     */
    public String getArtist() {
        return mArtist;
    }

    /**
     * Return the image resource ID of the song.
     */
    public int getImageResourceId() {
        return mImageResourceId;
    }

    /**
     * Returns whether or not there is an image for this song.
     */
    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }
}