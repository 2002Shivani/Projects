import plotly.graph_objs as go

# Define the data for the pie chart
labels = ['Apple', 'Banana', 'Cherry']
values = [30, 40, 30]
colors = ['#FFA07A', '#FFEFD5', '#FF69B4']

# Define the URL for each label
urls = {
    'Apple': 'https://www.apple.com',
    'Banana': 'https://www.banana.com',
    'Cherry': 'https://www.cherry.com'
}

# Define the layout of the pie chart
layout = go.Layout(
    title='Pie Chart with Clickable Slices',
    height=500,
    width=500,
    shapes=[],
    annotations=[]
)

# Define the coordinates for each slice
x_offset = -0.5
y_offset = -0.5
for i in range(len(values)):
    # Define the shape of the slice
    shape = dict(
        type='pie',
        x0=x_offset,
        y0=y_offset,
        x1=x_offset+0.5,
        y1=y_offset+0.5,
        line=dict(width=2),
        fillcolor=colors[i],
        opacity=0.8,
        text=labels[i],
        hoverinfo='text+value',
        value=values[i],
        name=labels[i],
        textposition='inside'
    )
    layout['shapes'] = list(layout['shapes'])
    layout['shapes'].append(shape)

    # Define the annotation for the slice
    annotation = dict(
        x=x_offset + 0.25,
        y=y_offset + 0.25,
        text=f'<a href="{urls[labels[i]]}">{labels[i]}</a>',
        showarrow=False,
        font=dict(size=12)
    )
    layout['annotations'] = list(layout['annotations'])
    layout['annotations'].append(annotation)

    x_offset += 0.5
    if x_offset > 0.5:
        x_offset = -0.5
        y_offset += 0.5

# Create the pie chart figure
fig = go.Figure(data=[], layout=layout)

# Show the pie chart
fig.show()
