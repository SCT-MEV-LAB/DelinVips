# A  non-linear delineation filter


---

## Table of Contents (Optional)

> If your `README` has a lot of info, section headers might be nice.

- [Definition](#definition)
- [Features](#features)
- [Contributing](#contributing)
- [Team](#team)
- [FAQ](#faq)
- [Support](#support)
- [License](#license)


---


---
## Definition

Delineation filter, which is  considered a sort of image preprocessing, is a common operation by consisting of scanning an image, looking for transitions between phases and choosing which phase the pixels belong to. In general, delineation filters are implemented using edge detection filters (Gonzalez $\&$ Woods, 2002) or through mathematical morphology (Serra, 1982 e 1988).

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
> Installing python

```shell
$ sudo apt-get install python 
```
> Installing Libvips
```shell
$ sudo apt-get install libvips libvips-dev 
$ sudo apt-get install libvips-tools
```
>Installing pyvips
```shell
$ sudo apt install python-pip
$ pip install --user pyvips 
```
> Installing FIJI
```shell
$ wget https://downloads.imagej.net/fiji/latest/fiji-linux64.zip 
```
---
## Results
We tested the performance of the proposed algorithm in different data sets. For this case, original image is a mineral ones obtained by reflected light optical microscopy (Figure \ref{a}). This input image have resolution of $1024 \times 1024$ pixels,  TIFF file,  8-bits and 1,1 MB.  By considering a Threshold parameter T=40 in the Delin filter with 3x3 mask, the processed computational time is given by  0m0,792s.

8bit and 1024x1024 pixels input image

![delin](https://user-images.githubusercontent.com/55209164/81089091-4c252300-8ed2-11ea-9610-507172798f78.jpg)  




Output image after using the Delin filter with threshold 100.

![delinT100](https://user-images.githubusercontent.com/55209164/81089882-4f6cde80-8ed3-11ea-92ed-bc68b7eef2ce.jpg)



