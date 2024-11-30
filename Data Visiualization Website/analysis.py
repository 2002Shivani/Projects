from flask import *
import pandas as pd
import numpy as np

import json
import plotly
import plotly.graph_objs as go
import plotly.express as px
 

app = Flask(__name__, template_folder='template', static_folder='static')
df_2 = pd.DataFrame()
df = pd.DataFrame()
Iitem =[]
Sitem = [] 
columns1 =[]
@app.route('/')
def index():
    return render_template('index.html')


@app.route('/back', methods=['GET', 'POST'])
def back():
    return render_template('index.html')


@app.route('/upload', methods=['GET', 'POST'])
def get_file():
    return render_template('fileUplod.html')

@app.route('/file_load', methods=['GET', 'POST'])
def analysis():
        global df_2
        global df
        global Iitem
        global Sitem
        global columns1
        if request.method == 'POST':
            file = request.files.get('file_choose')
            extension = file.content_type
            if extension == 'text/csv':
                df = pd.read_csv(file)
                print(df)
                print("I am from analysis done")
            else:
                df = pd.read_excel(file, engine='openpyxl')
                print(df)
                print("I am from analysis nothing")

            df_2 = df.dropna()
           
            Datainfox = len(df_2.axes[0])
            cols = len(df_2.axes[1])

            columns1 = df.columns.tolist()
            columns_types = df.dtypes.tolist()

            Sitem = columns1
            Iitem = columns1

            Iitem2=[]
            Sitem2=[]

            for i in range(len(columns_types)):
                if columns_types[i] == 'int64' or columns_types[i] == 'float64':
                    Iitem2.append(columns1[i])

                elif columns_types[i] == 'object':
                    Sitem2.append(columns1[i])
         
           
            x_title = 'X-Axis'
            y_title = 'Y Axis'
            chart_menu = ' '
            xaxis = Iitem[0]
            yaxis = Sitem[0]
           
            colorc = columns1[0]   
            vh = 'Horizontal'
            title = 'New Graph'
            ad = "total ascending"
            

            bar = create_plot(chart_menu, xaxis,yaxis,x_title,y_title,colorc,vh,title,ad)

            return render_template('analysis.html',row=Datainfox, column=cols, discreteItem=Sitem2, IntegerItem=Iitem2, IntegerItemx=columns1, discreteItemy=columns1,colorc = columns1,chart=bar)
       

def create_plot(chart_menu, xaxis,yaxis,x_title,y_title,colorc,vh,title,ad):
     global df_2
     global Iitem
     global Sitem
     global df
     global columns1
     print("I am here")
     print(xaxis)
     print(yaxis)
    
     
     print(chart_menu)
     print(colorc)
     print(Iitem)
     print(Sitem)
     print(df_2)
     print(columns1)
    
     x_i = Iitem.index(xaxis)
     y_i = Sitem.index(yaxis)
     c_i = columns1.index(colorc)
 
    
     if chart_menu == 'bc':
        if vh ==  'Horizontal':
            df_count = df_2.groupby(yaxis).count().reset_index() 
            data =px.bar(df_count,x = Iitem[x_i],y=Sitem[y_i],color=columns1[c_i])
            data.update_layout(
                         xaxis_title= x_title,
                         yaxis_title=y_title,
                            title=title,
                            yaxis = {"categoryorder":ad}
                        )
        else:
             df_count = df_2.groupby(xaxis).count().reset_index() 
             data =px.bar(df_count,x = Iitem[x_i],y=Sitem[y_i],color=columns1[c_i])
             data.update_layout(
                         xaxis_title= x_title,
                         yaxis_title=y_title,
                            title=title,
                            xaxis = {"categoryorder":ad}
                        )
       
     elif chart_menu == 'hc':
         df_count =df_2.groupby(Iitem[x_i])[Sitem[y_i]].nunique().reset_index()
         df_count.columns =[xaxis,'Total Count']
         data =px.histogram(df_count,x='Total Count',color='Total Count')
         data.update_layout(bargap=0.2)
         data.update_layout(
                         xaxis_title= x_title,
                         yaxis_title=y_title,
                            title=title,
                            xaxis = {"categoryorder":ad}
                        )

     elif chart_menu == 'pc':
         df_count = df_2.groupby(Sitem[y_i]).agg({Iitem[x_i]:'sum'}).reset_index() 
         data =px.pie(df_count,values=Iitem[x_i],names=Sitem[y_i],color=columns1[c_i] )
         data.update_traces(
                    
                            title=title,
                            textinfo='label+percent',
                            textposition='outside',
                          
                        )

     elif chart_menu == 'bct':
         if vh ==  'Vertical':
            df_box = df_2[[xaxis, Sitem[y_i]]].copy()
            df_box[xaxis] = pd.to_datetime(df_box[xaxis])
            df_box['month'] = df_box[xaxis].dt.month
            data = px.box(df_box, x='month', y=Sitem[y_i], color=columns1[c_i])
            data.update_layout(
                         xaxis_title= x_title,
                         yaxis_title=y_title,
                            title=title,
                            xaxis = {"categoryorder":ad}
                        )
         else:
            df_box = df_2[[yaxis, Iitem[x_i]]].copy()
            df_box[yaxis] = pd.to_datetime(df_box[yaxis])
            df_box['month'] = df_box[yaxis].dt.month
            data = px.box(df_box, x=Iitem[x_i], y='month', color=columns1[c_i])
            data.update_layout(
                         xaxis_title= x_title,
                         yaxis_title=y_title,
                            title=title,
                            xaxis = {"categoryorder":ad}
                        )
            
     elif chart_menu == 'lb':
        df_box = df_2[[Iitem[x_i], Sitem[y_i],columns1[c_i]]].copy()
        df_box[xaxis] = pd.to_datetime(df_box[Iitem[x_i]])
        df_box['year'] = df_box[xaxis].dt.year
     
        data = px.line(df_box, x='year', y=Sitem[y_i],color=columns1[c_i])
      



        # data.add_shape(
        #     type='line',
        #     x0=df_box[xaxis].min(),
        #     x1=df_box[xaxis].max(),
        #     y0=20,
        #     y1=20,
        #     line=dict(color='red', width=3, dash='dash')
        # )
        data.update_layout(
                         xaxis_title= x_title,
                         yaxis_title=y_title,
                            title=title,
                            xaxis = {"categoryorder":ad}
                        )
     elif chart_menu == 'dp':
         df_count = df_2.groupby(Sitem[y_i]).agg({Iitem[x_i]:'sum'}).reset_index() 
         data =px.pie(df_count,values=Iitem[x_i],names=Sitem[y_i],color=columns1[c_i] ,hole=0.5)
         data.update_traces(
                    
                            title=title,
                            textinfo='label+percent',
                            textposition='outside',
                          
                        )
    
     elif chart_menu == 'sp':
       df_count = df_2.groupby(yaxis).count().reset_index()
       data = px.scatter(df_count,x=columns1[c_i],y=Sitem[y_i],color=columns1[c_i])
       data.update_layout(
                         xaxis_title= x_title,
                         yaxis_title=y_title,
                            title=title,
                            xaxis = {"categoryorder":ad}
                        )
     else:
         data = go.Figure()
         data.update_layout(
                         xaxis_title= x_title,
                         yaxis_title=y_title,
                            title=title,
                            xaxis = {"categoryorder":ad}
                        )
    

     graphJSON = json.dumps(data, cls=plotly.utils.PlotlyJSONEncoder)

     return graphJSON
   
   
@app.route('/data', methods=['GET', 'POST'])
def data():
   
     chart_type = request.args['selected_type']
  
     xaxis = request.args['selected_x']
    
     yaxis = request.args['selected_y']
 
    
     x_title = request.args['selected_top']
    
     y_title = request.args['selected_bottom']

     colorc = request.args['selected_color']
    

     vh = request.args['selected_hv']
     ad = request.args['selected_ad']
  
     title = request.args['selected_title']
     
 
   

     graphJSON = create_plot(chart_type,xaxis,yaxis,x_title,y_title,colorc,vh,title,ad)
     return graphJSON

 


if __name__ == '__main__':
    app.run(debug=True)
