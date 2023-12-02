load("render.star", "render")

TRAIN_LINE_HEIGHT=8

def Row

def main():
    return render.Root(
        child=render.Column(
            children=[
                render.Row(
                    expanded=True,
                    main_align="space_between",
                    cross_align="end",
                    children=[
                        render.Box(width=10, height=8, color="#a00"),
                        render.Box(width=14, height=6, color="#0a0"),
                        render.Box(width=16, height=4, color="#00a"),
                    ],
)
                render.Box(width=8, height=2, color="#000000"),
                render.Box(width=8, height=TRAIN_LINE_HEIGHT, color="#FF0000"),
                render.Box(width=8, height=2, color="#000000"),
                render.Box(width=8, height=TRAIN_LINE_HEIGHT, color="#0000FF"),
                render.Box(width=8, height=2, color="#000000"),
                render.Box(width=8, height=TRAIN_LINE_HEIGHT, color="#800080"),
            ]
        ) 
    )