/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snake;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Ammar
 */
public class game extends JFrame implements  KeyListener{

    boolean up,down,lift,right,life;
    int xin=28,yin=56,counter=0,randoom; 
    boolean start=true;
     Random r=new Random ();
    block b,b1;
    ArrayList<block> array=new ArrayList();
   ArrayList<block> rand=new ArrayList();
    
    public game() throws InterruptedException{
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        addKeyListener(this);
        JPanel p=new JPanel();
        setSize(300,290);
        life=true;
        p.setLayout(null);
        add(p);
         
      b=new block();b.x=28;b.y=56;
      array.add(b);
      b=new block();b.x=21;b.y=56;
      array.add(b);
      b=new block();b.x=14;b.y=56;
      array.add(b);
      random();
     
      randoom=r.nextInt(rand.size());
      
     
        
    }
     public void random(){
         rand.removeAll(rand);
      for(int j=0;j<35;j++){
          for(int i=0;i<38;i++){
           counter=0;
              for(block b:array){
                  if((i*7+14)!=b.x||(j*7+28)!=b.y)counter++;
              }
              if(counter==array.size()){
                   
                  
              b1=new block();
              b1.x=(i*7+14);b1.y=(j*7+28);
              rand.add(b1);
              
              }
              
              
          }
              
        
      } 
      System.out.println(rand.size());
     }
    
     
     @Override
     public void paint(Graphics g){
     if(start){
       // System.out.println(array.size()); 
         g.setColor(Color.green);
         g.fillRect(array.get(2).x, array.get(2).y, 7, 7);
          
         g.fillRect(array.get(1).x, array.get(1).y, 7, 7);
         g.setColor(Color.black);
         g.fillRect(array.get(0).x, array.get(0).y, 7, 7);
         g.setColor(Color.red);
         g.fillRect(rand.get(randoom).x, rand.get(randoom).y, 7, 7);
         
         
        
     }
     if(!start){
     g.setColor(Color.WHITE);
     g.fillRect(0, 0, 300, 290);
     }
     
     g.setColor(Color.RED);
     g.fillRect(rand.get(randoom).x, rand.get(randoom).y, 7, 7);
     g.drawRect(14, 28, 273, 252);
     g.drawRect(13, 27, 275, 254);
      g.setColor(Color.BLACK);
     
     
      if(up){
       
      for(int i=array.size()-1;i>0;i--){
          array.get(i).x=array.get(i-1).x;
          array.get(i).y=array.get(i-1).y;
      }
       yin=yin-7;
        array.get(0).y=yin;
         g.fillRect(xin, yin, 7, 7);
      for(int i=1;i<array.size();i++)
      {
        g.setColor(Color.GREEN); g.fillRect(array.get(i).x, array.get(i).y, 7, 7);
      
       
      }
      if(array.get(0).y<28){
          int size=array.size();
        
          for(int i=size-1;i>2;i--)
             
                  array.remove(i);
          
          
          array.get(0).x=28;array.get(0).y=56;
          array.get(1).x=21;array.get(1).y=56;
          array.get(2).x=14;array.get(2).y=56;
          
          xin=28;yin=56;
          start=true;up=down=right=lift=false;
          g.setColor(Color.WHITE);
          g.fillRect(0, 0,300, 290);
          g.setColor(Color.RED);
          g.drawRect(14, 28, 273, 252);
         
      }
      if(yin==rand.get(randoom).y&&xin==rand.get(randoom).x){
          random();
          randoom=r.nextInt(rand.size());
          b=new block();
          b.x=-7;b.y=-7;
          array.add(b);
      }
      
      for(int i=1;i<array.size();i++)
          if(array.get(0).x==array.get(i).x&&array.get(0).y==array.get(i).y){
              int size=array.size();
              for(int j=size-1;j>2;j--)
             
                  array.remove(j);
          
          
          array.get(0).x=28;array.get(0).y=56;
          array.get(1).x=21;array.get(1).y=56;
          array.get(2).x=14;array.get(2).y=56;
          
          xin=28;yin=56;
          start=true;up=down=right=lift=false;
          g.setColor(Color.WHITE);
          g.fillRect(0, 0,300, 290);
          g.setColor(Color.RED);
          g.drawRect(14, 28, 273, 252);
         
          }
      }
    else if(down){
       
      for(int i=array.size()-1;i>0;i--){
          array.get(i).x=array.get(i-1).x;
          array.get(i).y=array.get(i-1).y;
      }
       yin=yin+7;
        array.get(0).y=yin;
         g.fillRect(xin, yin, 7, 7);
      for(int i=1;i<array.size();i++)
      {
        g.setColor(Color.GREEN); g.fillRect(array.get(i).x, array.get(i).y, 7, 7);
      
       
      }
          if(array.get(0).y>273){
           int size=array.size();
        
          for(int i=size-1;i>2;i--)
             
                  array.remove(i);
          array.get(0).x=28;array.get(0).y=56;
          array.get(1).x=21;array.get(1).y=56;
          array.get(2).x=14;array.get(2).y=56;
          xin=28;yin=56;
          start=true;up=down=right=lift=false;
          g.setColor(Color.WHITE);
          g.fillRect(0, 0,300, 290);
          g.setColor(Color.RED);
          g.drawRect(14, 28, 273, 252);
          
      }
           if(yin==rand.get(randoom).y&&xin==rand.get(randoom).x){
          random();
          randoom=r.nextInt(rand.size());
           b=new block();
          b.x=-7;b.y=-7;
          array.add(b);
      }
            for(int i=1;i<array.size();i++)
          if(array.get(0).x==array.get(i).x&&array.get(0).y==array.get(i).y){
              int size=array.size();
              for(int j=size-1;j>2;j--)
             
                  array.remove(j);
          
          
          array.get(0).x=28;array.get(0).y=56;
          array.get(1).x=21;array.get(1).y=56;
          array.get(2).x=14;array.get(2).y=56;
          
          xin=28;yin=56;
          start=true;up=down=right=lift=false;
          g.setColor(Color.WHITE);
          g.fillRect(0, 0,300, 290);
          g.setColor(Color.RED);
          g.drawRect(14, 28, 273, 252);
         
          
          }
             for(int i=1;i<array.size();i++)
          if(array.get(0).x==array.get(i).x&&array.get(0).y==array.get(i).y){
              int size=array.size();
              for(int j=size-1;j>2;j--)
             
                  array.remove(j);
          
          
          array.get(0).x=28;array.get(0).y=56;
          array.get(1).x=21;array.get(1).y=56;
          array.get(2).x=14;array.get(2).y=56;
          
          xin=28;yin=56;
          start=true;up=down=right=lift=false;
          g.setColor(Color.WHITE);
          g.fillRect(0, 0,300, 290);
          g.setColor(Color.RED);
          g.drawRect(14, 28, 273, 252);
         
          
          }
      }     
    else if(right){
       
      for(int i=array.size()-1;i>0;i--){
          array.get(i).x=array.get(i-1).x;
          array.get(i).y=array.get(i-1).y;
      }
       xin=xin+7;
        array.get(0).x=xin;
         g.fillRect(xin, yin, 7, 7);
      for(int i=1;i<array.size();i++)
      {
        g.setColor(Color.GREEN); g.fillRect(array.get(i).x, array.get(i).y, 7, 7);
      
       
      }
          if(array.get(0).x>280){
            int size=array.size();
        
          for(int i=size-1;i>2;i--)
             
                  array.remove(i);
          
          array.get(0).x=28;array.get(0).y=56;
          array.get(1).x=21;array.get(1).y=56;
          array.get(2).x=14;array.get(2).y=56;
          xin=28;yin=56;
          start=true;up=down=right=lift=false;
          g.setColor(Color.WHITE);
          g.fillRect(0, 0,300, 290);
          g.setColor(Color.RED);
          g.drawRect(14, 28, 273, 252);
         
      }
           if(yin==rand.get(randoom).y&&xin==rand.get(randoom).x){
          random();
          randoom=r.nextInt(rand.size());
           b=new block();
          b.x=-7;b.y=-7;
          array.add(b);
      }
            for(int i=1;i<array.size();i++)
          if(array.get(0).x==array.get(i).x&&array.get(0).y==array.get(i).y){
              int size=array.size();
              for(int j=size-1;j>2;j--)
             
                  array.remove(j);
          
          
          array.get(0).x=28;array.get(0).y=56;
          array.get(1).x=21;array.get(1).y=56;
          array.get(2).x=14;array.get(2).y=56;
          
          xin=28;yin=56;
          start=true;up=down=right=lift=false;
          g.setColor(Color.WHITE);
          g.fillRect(0, 0,300, 290);
          g.setColor(Color.RED);
          g.drawRect(14, 28, 273, 252);
         
          
          }
      }
      
     else if(lift){
       
      for(int i=array.size()-1;i>0;i--){
          array.get(i).x=array.get(i-1).x;
          array.get(i).y=array.get(i-1).y;
      }
       xin=xin-7;
        array.get(0).x=xin;
         g.fillRect(xin, yin, 7, 7);
      for(int i=1;i<array.size();i++)
      {
        g.setColor(Color.GREEN); g.fillRect(array.get(i).x, array.get(i).y, 7, 7);
      
       
      }
      if(array.get(0).x<14){
            int size=array.size();
        
          for(int i=size-1;i>2;i--)
             
                  array.remove(i);
          array.get(0).x=28;array.get(0).y=56;
          array.get(1).x=21;array.get(1).y=56;
          array.get(2).x=14;array.get(2).y=56;
          xin=28;yin=56;
          start=true;up=down=right=lift=false;
          g.setColor(Color.WHITE);
          g.fillRect(0, 0,300, 290);
          g.setColor(Color.RED);
          g.drawRect(14, 28, 273, 252);
        
      }
       if(yin==rand.get(randoom).y&&xin==rand.get(randoom).x){
          random();
          randoom=r.nextInt(rand.size());
           b=new block();
          b.x=-7;b.y=-7;
          array.add(b);
      }
        for(int i=1;i<array.size();i++)
          if(array.get(0).x==array.get(i).x&&array.get(0).y==array.get(i).y){
              int size=array.size();
              for(int j=size-1;j>2;j--)
             
                  array.remove(j);
          
          
          array.get(0).x=28;array.get(0).y=56;
          array.get(1).x=21;array.get(1).y=56;
          array.get(2).x=14;array.get(2).y=56;
          
          xin=28;yin=56;
          start=true;up=down=right=lift=false;
          g.setColor(Color.WHITE);
          g.fillRect(0, 0,300, 290);
          g.setColor(Color.RED);
          g.drawRect(14, 28, 273, 252);
         
          
          }
      
      }
      
     
   
    
        
          
      
      }
      
     

    @Override
    public void keyTyped(KeyEvent ke) {
    }

    @Override
    public void keyPressed(KeyEvent ke) {
 if(ke.getKeyCode()==KeyEvent.VK_UP&&!down){
   if((array.get(0).y==array.get(1).y+7)&&lift){lift=true;up=false;}
      else if((array.get(0).y==array.get(1).y+7)&&right){right=true;up=false;}
      else{
     up=true;
    down=false;
    right=false;
    lift=false;
    start=false;
      }
     
 }
 
  if(ke.getKeyCode()==KeyEvent.VK_DOWN&&!up){
       if((array.get(0).y==array.get(1).y-7)&&lift){lift=true;down=false;}
      else if((array.get(0).y==array.get(1).y-7)&&right){right=true;down=false;}
       else{
      up=false;
    down=true;
    right=false;
    lift=false;
     start=false;
       }
 }
    
   if(ke.getKeyCode()==KeyEvent.VK_RIGHT&&!lift){
      if((array.get(0).x==array.get(1).x-7)&&up){up=true;right=false;}
      else if((array.get(0).x==array.get(1).x-7)&&down){down=true;right=false;}
      else{
       up=false;
    down=false;
    right=true;
    lift=false;
     start=false;
      }
     
 }
     if(ke.getKeyCode()==KeyEvent.VK_LEFT&&!right&&!start){
     if((array.get(0).x==array.get(1).x+7)&&up){up=true;lift=false;}
      else if((array.get(0).x==array.get(1).x+7)&&down){down=true;lift=false;}
      else{ up=false;
    down=false;
    right=false;
    lift=true;
     start=false;}
    
 }
    
    
    
    
    }

    @Override
    public void keyReleased(KeyEvent ke) {


    }

   
       
         }

   
    

