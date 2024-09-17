## Recycler View
This project demonstrates a modern and recommended approach to display an Array of objects like
a list view, via the `RecylerView` instead.

### The goal
This project explores how to display list items -- Items that are normally displayed as a list of
entries. Where the data source is often an array of items.

Example Item lists:
- Music Playlist
- Contacts

```json
[
  {
    "name": "Steve",
    "job": "Hunter"
  },
  {
    "name": "Alex",
    "job": "Farmer"
  }
]
```

<br>

### Architecture and Special features of Recycler View
Unlike our `ListView` a `RecyclerView` has an additional flexibility of configuring the orientation
and overall layout to display our array items.

Those layout configurations comes in the form of `RecyclerView.LayoutManager` class implementations.
- `LinearLayoutManager` arranges the items in a one-dimensional list. Like `ListView`
- `GridLayoutManager` arranges the items in a two-dimensional grid:
    - If the grid is arranged vertically, `GridLayoutManager` tries to make all the elements in each 
      row have the same width and height, but different rows can have different heights.
    - If the grid is arranged horizontally, `GridLayoutManager` tries to make all the elements in 
      each column have the same width and height, but different columns can have different widths.
- `StaggeredGridLayoutManager`is similar to `GridLayoutManager`, but it does not require that items 
  in a row have the same height (for vertical grids) or items in the same column have the same width
  (for horizontal grids). The result is that the items in a row or column can end up offset from 
  each other.


We need to prepare 3 classes and a layout resource file:
- `Model` class which represents each individual entry in our json
- `RecyclerViewAdapter` class which will inflate the view layouts
- `ViewHolder` class which the `RecyclerViewAdapter` enforces the use of.
- `model_items_view` which is the XML resources that defines each individual list item's UI appearance. The `LayoutManager` will arrange each individual
  item's view on top of each other automatically and dictate the lifecycle calls.

