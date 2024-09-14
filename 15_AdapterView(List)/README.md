## Adapter views
This example implements the ListView layout. Its a legacy way of displaying a list of items, for 
more modern approach see 16_RecyclerView

<br>

### The goal
This project explores how to display list items -- Items that are normally displayed as a list of 
entries. Where the data source is often an array of items.

Example Item lists:
- Music Playlist
- Contacts

![](/docs/static/goal.png)

<br>

### Architectures
We have a data source like an array of objects, and we want to display them as a list. The `ListView` ViewGroup component will
be used as the entry point to our data for the User. It handles the logics for scrolling while we handle the logic of assigning data from
our Models to our custom layout.

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

We need to prepare 2 classes and a layout resource file:
- `Model` class which represents each individual entry in our json
- `ArrayAdapter` class which will inflate the view layouts
- `model_items_view` which is the XML resources that defines each individual list item's UI appearance. The `ListView` will arrange each individual
  item's view on top of each other automatically and dictate the lifecycle calls.


<br><br>


