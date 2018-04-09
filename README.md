# Iroh
Iroh will be a very fancy Tea Timer. Using machine learning it will help try to make the perfect cup of tea, by suggesting temperatures and brew times. This machine learning hub will be located on a Raspberry Pi for my installation, and be accessable through an android app, web page, and desktop app, allowing me to keep track of my teapot no matter what I am doing.
## Data
From my experience with tea, Iroh will need to know a few things to determine the proper brewing temperature and times for tea.
* Color: Generally color is one of the most important factors in determining temperature and brewing time, with black tea requiring boiling water, and around 4 minutes, and white tea requiring 170°F(76°C) and 2-3 minutes
* Type: Some teas do vary with brewing temperature and times from their color. For example, Hojicha, while a green tea, brews at 185­­°F instead of 170°F, and for 2 minutes instead of 3.
* Age: As tea ages it loses some of it's flavor, and may require longer to brew
* Rebrew: Tea that has been already brewed also loses some of it's flavor, and will take longer to brew.

A Rating property will also need to be provided, so that Iroh knows what good tea is.
 
 Color and Type will be provided by the user when they add a tea. Rebrew status will be provided when a user brews a tea, and age should be calculated by Iroh if available, or estimated by the user when entering in the tea.
 