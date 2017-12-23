package com.jimmie.test.nio.mytest;

// $Id$

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

public class CopyFile
{
  static public void main( String args[] ) throws Exception {
/*    if (args.length<2) {
      System.err.println( "Usage: java CopyFile infile outfile" );
      System.exit( 1 );
    }*/

    String infile = "D:\\/filetest\\/readandshow.txt";
    String outfile = "D:\\/filetest\\/readandshow2.txt";

    FileInputStream fin = new FileInputStream( infile );
    FileOutputStream fout = new FileOutputStream( outfile );

    FileChannel fcin = fin.getChannel();
    FileChannel fcout = fout.getChannel();

    ByteBuffer buffer = ByteBuffer.allocate( 1024 );

    while (true) {
      buffer.clear();

      int r = fcin.read( buffer );

      if (r==-1) {
        break;
      }
//      System.out.println(new String(buffer.array(),Charset.defaultCharset()));//打印
      buffer.flip();

      fcout.write( buffer );
    }
  }
}
