from __future__ import print_function
import pickle
import os.path
from googleapiclient.discovery import build
from google_auth_oauthlib.flow import InstalledAppFlow
from google.auth.transport.requests import Request
import time
# import BaseHTTPServer
import http.server
from test import backend


HOST_NAME = '10.105.200.129' # !!!REMEMBER TO CHANGE THIS!!!
PORT_NUMBER = 8080 # Maybe set this to 9000.

ans = backend()

class MyHandler(http.server.BaseHTTPRequestHandler):
    def do_HEAD(s):
        s.send_response(200)
        s.send_header("Content-type", "text/html")
        s.end_headers()
    def do_GET(s):
        """Respond to a GET request."""
        s.send_response(200)
        s.send_header("Content-type", "text/html")
        s.end_headers()
#         s.wfile.write(main())
        print(backend())
        # a = bytes("backend", "UTF-8")
        s.wfile.write(str(backend()).encode())
#         s.wfile.write("<html><head><title>Title goes here.</title></head>")
#         s.wfile.write("<body><p>This is a test.</p>")
#         # If someone went to "http://something.somewhere.net/foo/bar/",
#         # then s.path equals "/foo/bar/".
#         s.wfile.write("<p>You accessed path: %s</p>" % s.path)
#         s.wfile.write("</body></html>")

    
def main():
    server_class = http.server.HTTPServer
    httpd = server_class((HOST_NAME, PORT_NUMBER), MyHandler)
    print (time.asctime(), "Server Starts - %s:%s" % (HOST_NAME, PORT_NUMBER))
    try:
        httpd.serve_forever()
    except KeyboardInterrupt:
        pass
    httpd.server_close()
    print (time.asctime(), "Server Stops - %s:%s" % (HOST_NAME, PORT_NUMBER))


if __name__ == '__main__':
    main()
