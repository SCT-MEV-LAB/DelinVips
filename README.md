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

This repo  deal with  delineation algorithm for image processing proposed by Gomes O.F. (See  ...). It contains the source code for DelinVips filter (i.e., plugins developed by the  Scanning Electron Microscope laboratory  team at the Mineral Center of Technology ([CETEM](www.cetem.gov.br)). Check the packages directory for the plugins.

--- 
## Prerequisites

- For Linux/windows/mac platform you have to do:

> update and install this package first

```shell
$ sudo apt-get update && sudo apt-get upgrade
```

> Install java packages

```shell
$ sudo apt-get install default-jdk
$ sudo  apt-get install wget
```
> Install python3

```shell
$ sudo apt-get install python3 
```
> Install [Libvips](https://github.com/libvips/libvips)

- For windows, [see Latest release](https://github.com/libvips/libvips/releases)

- To  build from source : [Build for Ubuntu](https://github.com/libvips/libvips/wiki/Build-for-Ubuntu)


>Install pyvips (https://pypi.org/project/pyvips/)

Non-conda install:
```shell
$ pip install --user pyvips 
```
Conda install:
```shell
$  conda install --channel conda-forge pyvips
```

> Install FIJI
```shell
$ wget https://downloads.imagej.net/fiji/latest/fiji-linux64.zip 
```
- Uninstall Libvips built from source, just make uninstall from the directory you ran make install in. If you no longer have the build area, you can install again, then immediately uninstall afterwards.  
By default, it will  have installed to /usr/local. So, you can also just go there and delete the files by hand. 

---

## Management for delin_vips code
- Vips version: 2.1.12
- Libvips version 8.8.0
- Python 3.6


## Usage

DelinVips filter can be used for determining  edges and lines pixels in the pre-processing of an image.




## Results
We tested the performance of the proposed algorithm in different data sets. For this case, original image is a mineral ones obtained by reflected light optical microscopy. See Figure (a). This input image have resolution of 1024 x 1024 pixels,  TIFF file,  8-bits and 1,1 MB.  By considering a Threshold parameter T=40 in the Delin filter with 3x3 mask, the processed computational time is given by  0m0,792s.

Figure (a):  8bit and 1024x1024 pixels input image

![delin](https://user-images.githubusercontent.com/55209164/81089091-4c252300-8ed2-11ea-9610-507172798f78.jpg)  




Figure (b):  Output image after using the Delin filter with threshold value 100.

![delinT100](https://user-images.githubusercontent.com/55209164/81089882-4f6cde80-8ed3-11ea-92ed-bc68b7eef2ce.jpg)


## Support

