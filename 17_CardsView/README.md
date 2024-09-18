## Card View
> [docs](https://developer.android.com/develop/ui/views/layout/cardview)

This project demonstrates a modern and recommended approach to display an Array of objects like
in a grid of cards view, via the `RecylerView`

<br>

### Dependencies
`CardView` uses the following dependency so be sure to include them in your `build.gradle`
```
dependencies {
    implementation "androidx.cardview:cardview:1.0.0"  
}
```
<br>

### The goal

![](docs/static/android%20card%20view.png)


<br>

### Architecture
We have a data source like an array of objects, and we want to display them as a grid of cards. The `RecylerView` component will
be used as the entry point to our data for the User. While the `CardView` will provide the styling aespects of cards appearance
such as:

- Elevated shadows
- Rounded Corners

etc.

Since we are letting the `RecyclerView` dictate the arrangement of our cards, the `GridLayoutManager` will be used.
See `LayoutManagers` from 16_RecyclerView examples and the android developer docs for more details on its configuration options

Below is a typical data model that we will use to display with the `CardView`. In although its possible to use a URI, in our case images are stored in `res/drawable`, thus the `resourceLocatorId` is used instead

```json
[
  {
    "name": "Steve",
    "image": "uri://",
    "job": "Hunter"
  },
  {
    "name": "Alex",
    "image": "uri://",
    "job": "Farmer"
  }
]
```

To create a cardsview, we need to define a few objects:
- `Model` class which represents each individual entry in our json
- `CardView` xml layout root container representing each individual items within the RecyclerView's body
- `RecyclerViewAdapter` class which will inflate the view layouts
- `ViewHolder` class which the `RecyclerViewAdapter` enforces the use of.

