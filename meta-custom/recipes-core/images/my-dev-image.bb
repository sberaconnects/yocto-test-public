SUMMARY = "My Dev Image"
LICENSE = "MIT"
inherit my-image

IMAGE_FEATURES:append = " \
    tools-debug \
    ssh-server-openssh \
"
