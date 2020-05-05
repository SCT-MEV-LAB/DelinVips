# A  non-linear delineation filter


---

## Table of Contents


- [Definition](#definition)
- [Prerequisites](#prerequisites)
- [Results](#results)
- [FAQ](#faq)
- [Support](#support)
- [License](#license)


---


---
## Definition

This repo  deal with  delineation algorithm for image processing. It contains the source code for DelinVips filter (i.e., plugins developed by the  Scanning Electron Microscope laboratory  team at the Mineral Center of Technology ([CETEM ](www.cetem.gov.br)). Check the packages directory for the plugins.

--- 
## Prerequisites

- For Linux platform you have to do:

> update and install this package first

```shell
$ sudo apt-get update && sudo apt-get upgrade
```

> now install java packages

```shell
$ sudo apt-get install default-jdk
$ sudo  apt-get install wget
```
> Install python

```shell
$ sudo apt-get install python 
```
> Install [Libvips](https://github.com/libvips/libvips)
```shell
$ sudo apt-get install libvips libvips-dev 
$ sudo apt-get install libvips-tools
```
>Install pyvips
```shell
$ sudo apt install python-pip
$ pip install --user pyvips 
```
> Install FIJI
```shell
$ wget https://downloads.imagej.net/fiji/latest/fiji-linux64.zip 
```
---
## Usage

DelinVips filter can be used for determining  edges and lines pixels in the pre-processing of an image. 

## Results
We tested the performance of the proposed algorithm in different data sets. For this case, original image is a mineral ones obtained by reflected light optical microscopy. See Figure (a). This input image have resolution of 1024 x 1024 pixels,  TIFF file,  8-bits and 1,1 MB.  By considering a Threshold parameter T=40 in the Delin filter with 3x3 mask, the processed computational time is given by  0m0,792s.

Figure (a):  8bit and 1024x1024 pixels input image

![delin](https://user-images.githubusercontent.com/55209164/81089091-4c252300-8ed2-11ea-9610-507172798f78.jpg)  




Figure (b):  Output image after using the Delin filter with threshold value 100.

![delinT100](https://user-images.githubusercontent.com/55209164/81089882-4f6cde80-8ed3-11ea-92ed-bc68b7eef2ce.jpg)


## Support

