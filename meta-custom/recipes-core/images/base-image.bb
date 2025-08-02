SUMMARY = "Generic Base Development Image"
LICENSE = "MIT"

inherit core-image

IMAGE_FEATURES += "package-management ssh-server"
IMAGE_INSTALL:append = " bash"

EXTRA_USERS_PARAMS = "usermod -p '' root;"
