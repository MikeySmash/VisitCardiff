package com.example.android.visitcardiff;

class Content {

    /**    Name of the atttraction */
    private int mAttractionName ;
    /**   Summary of the atttraction */
    private int mAttractionSummary ;
    /**   Address of the atttraction */
    private int mAttractionAddress ;
    /**   Telephone number of the attraction */
    private int mAttractionPhone ;
    /**   Website address of the attraction */
    private int mAttractionWebsite ;
    /**   Image ID of the attraction */
    private int mAttractionImageResourceId ;
    /**   Small image ID of the attraction */
    private int mSmallImageResourceId ;
    /**   Latitude of the attraction */
    private int mLatitudeId ;
    /**   Longitude of the attraction */
    private int mLongitudeId ;

    /** Constant value that represents no image was provided for this word */
    private static final int NO_IMAGE_PROVIDED = -1;

    /**
     * Create a new Content object.
     * @param attractionName    Name of the attraction, restaurant, hotel, etc.
     * @param attractionSummary Summary of attraction, etc
     * @param attractionAddress Address of attraction
     * @param attractionPhone   Telephone number of attraction, etc.
     */
    public Content (int attractionName, int attractionSummary,
                    int attractionAddress, int attractionPhone, int attractionWebsite, int latitudeId, int longitudeId){
        mAttractionName = attractionName;
        mAttractionSummary = attractionSummary;
        mAttractionAddress = attractionAddress;
        mAttractionPhone = attractionPhone;
        mAttractionWebsite = attractionWebsite;
        mLatitudeId = latitudeId;
        mLongitudeId = longitudeId;

    }
    /**
     * Create a new Content object.
     * @param attractionName            Name of the attraction, restaurant, hotel, etc.
     * @param attractionSummary         Summary of attraction, etc.
     * @param attractionAddress         Address of attraction, etc.
     * @param attractionPhone           Telephone number of attraction, etc.
     * @param attractionImageResourceId ID of image for each attraction, hotel, etc.
     */
    public Content (int attractionName, int attractionSummary,
                    int attractionAddress, int attractionPhone, int attractionImageResourceId,
                    int smallImageId, int attractionWebsite, int latitudeId, int longitudeId){
        mAttractionName = attractionName;
        mAttractionSummary = attractionSummary;
        mAttractionAddress = attractionAddress;
        mAttractionPhone = attractionPhone;
        mAttractionImageResourceId = attractionImageResourceId;
        mSmallImageResourceId = smallImageId;
        mAttractionWebsite = attractionWebsite;
        mLatitudeId = latitudeId;
        mLongitudeId = longitudeId;

    }
    /**
     * Get the name of the attraction, hotel, etc.
     */
    public int getmAttractionName() {
        return mAttractionName;
    }
    /**
     * Get the address of the attraction, hotel, etc.
     */
    public int getmAttractionAddress() {
        return mAttractionAddress;
    }
    /**
     * Get the summary of the attraction, hotel, etc.
     */
    public int getmAttractionSummary() {
        return mAttractionSummary;
    }
    /**
     * Get the telephone number of the attraction, hotel, etc.
     */
    public int getmAttractionPhone() {
        return mAttractionPhone;
    }
    /**
     * Returns whether or not there is an image for this word.
     */
    public boolean hasImage() {
        return mAttractionImageResourceId != NO_IMAGE_PROVIDED;
    }
    /**
     * Get the image ID of the attraction, hotel, etc.
     */
    public int getmAttractionImageResourceId() {
        return mAttractionImageResourceId;
    }

    public int getmSmallImageResourceId() {
        return mSmallImageResourceId;
    }

    public int getmAttractionWebsite() {
        return mAttractionWebsite;
    }

    public int getmLatitudeId() {
        return mLatitudeId;
    }
    public int getmLongitudeId() {
        return mLongitudeId;
    }


}
