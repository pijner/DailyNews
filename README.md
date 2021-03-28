# Daily News Feed

This is a single JSF web-page that pulls Canada's top news articles using [NewsAPI](https://newsapi.org/) and facilitates current weather lookup using [WeatherAPI](https://www.weatherapi.com/). The purpose of this application is to demonstrate the use of PrimeFaces components with Ajax for an interactive web page. The app can be run through NetBeans or using the docker image provided.

**NOTE: The API keys used in this project belong to the creator of this project ([pijner](https://github.com/pijner)) and are provided solely for demonstration purposes. The use of the keys given is not authorized beyond the scope of demonstration.**

---

**The requirements provided prior to the development of this project are listed below**

On this page, you have to make use of 5 different UI components from [PrimeFaces](https://www.primefaces.org/showcase/index.xhtml?jfwid=ce03f)

 - Make sure that these are new components that we did not introduce in the class. For example, adding a button although might be necessary will NOT be counted as one of the UIs.
 - Some of the UI elements you may consider are Carousel, DataView, Chronoline, GMap, AccordionPanel, PanelGrid, ScrollPanel, Sidebar, etc.
 - All elements should be functional and related to your proposed idea. So, you can borrow a component about car types and then, another one about fruits.

---

## Components Used

This project was developed using PrimeFaces version `10.0.0-RC1`. The use of the code in this project may not work as expected in older versions of PrimeFaces. The *new* components used are listed below

 - Splitter
 - Fieldset
 - PanelGrid
 - Card
 - Clock
 - GraphicImage

## Usage
Make sure Docker engine is up and running by using the following command.

    $ docker ps

The base image used in the `Dockerfile` provided is payara-micro. You will either need to have this on your device or need access to docker-hub.

Run the `Dockerfile` to create an image with the `.war` file for the project. Note that you need to be in the project directory, where the `Dockerfile` is located, to run this script in your terminal.
  
    # Build the image
    docker build --tag dni .
    # Create a container with this image
    docker run --name dnc -p 8080:8080 dni

Once the container is up and running, you will see the following message in the terminal
    
    [INFO] [] [PayaraMicro] [tid: _ThreadID=1 _ThreadName=main] [timeMillis: 1616895201401] [levelValue: 800] Payara Micro  5.2021.1 #badassmicrofish (build 2818) ready in 22,431 (ms)

- Navigate to the following URL using a browser
    
    `http://localhost:8080/DailyNews-1.0`


## Cleanup 
  
    # To stop the container, use the following
    docker container stop dnc
    # To remove the container from your computer:
    docker rm dnc
    # To remove the image from your computer:
    docker rmi dni

