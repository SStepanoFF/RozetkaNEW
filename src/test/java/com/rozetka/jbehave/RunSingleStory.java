package com.rozetka.jbehave;

import java.io.File;

/**
 * Created by Sergii_Stepanov on 10/29/2015.
 */
public class RunSingleStory extends AcceptanceTestSuite {
    private String storyPath=".\\stories\\prodDetails_dictionary\\AddToWishlist.story";

    @Override
    protected String getStoryPath(){
        return storyPath;
    }

}
