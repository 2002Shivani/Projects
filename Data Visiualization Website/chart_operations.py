import pandas as pd 
import numpy as np 
import plotly
import plotly.express as px
import plotly.graph_objs as go
import numpy as np
import json

def chart_data(df_2,Iitem , Sitem ,top , bottom ,x_axis,y_axis,operation):
               
               fig = px.bar(df_2, x= Iitem[x_axis], y= Sitem[y_axis],  barmode='group')
               graphJSON = json.dumps(fig, cls=plotly.utils.PlotlyJSONEncoder)
               return graphJSON

def bar(df_2,Iitem , Sitem ,top , bottom ,x_axis,y_axis,operation):
    print("Bar chart")
   

def scatter():
    print("Scatter")


def bar():
    print("shivani")


def bar():
    print("shivani")


def bar():
    print("shivani")