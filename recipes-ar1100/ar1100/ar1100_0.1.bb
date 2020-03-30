SUMMARY = "AR1100"
DESCRIPTION = "Configure AR1100 for everything yocto"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${S}/LICENSE;md5=2b787c0622a7b91d9f5198124854e87d"
DEPENDS += "libusb1 libusb-compat gtk+3 cairo"

S = "${WORKDIR}/git"

inherit cmake pkgconfig

OECMAKE_GENERATOR = "Unix Makefiles"

PACKAGECONFIG ??= ""
#PACKAGECONFIG[pcre] = "--enable-pcre,--disable-pcre,libpcre"

SRC_URI = "git://github.com/reworled/ar1100.git;branch=master;protocol=git"
SRCREV = "b5fec96ce5ef7e7ac8f7f7e47195fbf86632df51"
SRC_URI[md5sum] = "3fd7ad10dd2984ef01c95af5832ba2b1"

FILES_${PN} += "/opt/AR1100/bin/AR1100"

do_compile () {
    oe_runmake all
}


