## Vector-draw

###  The requirements meeted

- Basic requirements
  - Drawing straight lines
  - Drawing rectangles
  - Drawing ellipses
  - Drawing 5-pointed stars
  - Undo/redo
  - Different colours
- Advanced requirements
  - squares and circles
  - triangles, parallelograms, hexagons



### How to run

直接运行项目src目录下的Main类里面的main方法即可。junit版本为4.10

### Features

本项目简单实现了一个简单的画板， 使用的是mvc模式。运行main方法后，会弹出画板。上面的一排第一个按钮可以选择颜色，后面跟着的是各种图形，最后连个是undo和redo按钮。按下颜色按钮选择你想要的颜色，再按下你想画的图形的按钮，然后点击鼠标在下面的画板上拖动，即可画出你想要的图形。undo按钮可以撤销你上一次画的图形。redo按钮可以撤销你的上一次撤销操作。

本项目目录分为components， icon， model和shape四个文件夹。

- shape文件夹里面装的是shape实体类。其中父类是我自定义的MyShape类，该类定义了图形的起点，终点和颜色，以及画图形的抽象方法。其他的类都直接或间接继承了这个MyShape类，然后实现draw方法。其中，大部分的类都使用了awt.geom下的类实现好的画图方法。比如Ellipse2D.Double（），Line2D.Double（）等。五角星，三角形，菱形和六边形则是通过根据起点和终点模拟其他点的位置，然后连线画出图形。因此如果拖动鼠标时采用了刁钻的角度，最终画出的图形会不标准，请谅解。
- components放的是我自己实现的按钮和panel，以及初始化渲染画板的CreateGUI类。其中，MyButton类可以读取icon中的图片来为自定义按钮选择美观的图片。
- icon装的是各个按钮的图标图片。
- model文件夹装的是Model类，即MVC对应的M， 定义了the current color to use， the current shape to use (Distinguished by the name of the shape)， the shapes that have been drawn on the drawing board， the shapes that have been drawn and undo， and components of observer pattern.只要model类中的属性发生了变化，就会把所有图形重新画一遍。也正因如此，非常遗憾，该项目无法对已经画了的图形做出修改大小位置和颜色的操作。

### Junit tests

在test包下有两个测试类，分别是测试model类和测试按钮的。点击类名左边的run按钮，即可一次性运行该类下的所有测试方法。最终会返回测试的结果。绿色即表示全部测试通过