from ppadb.client import Client as AdbClient
import time

client = AdbClient(host= "127.0.0.1", port=5037)
devices = client.devices()

device = devices[0]

device.shell("svc data disable")
device.shell("settings put global airplane_mode_on 1")

time.sleep(4)

device.shell("settings put global airplane_mode_on 0")