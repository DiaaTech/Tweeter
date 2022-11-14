<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Add Tweet</title>
    <link rel="stylesheet" href="css/addTweet.css" />
  </head>
  <body>
    <nav>
      <h1>Tweeter</h1>
    </nav>

    <div class="container">
      <!-- Body, Tags -->
      <form method="POST" action="addTweet">
        <h1>Post Your Tweet</h1>
        <textarea name="body" placeholder="What you're thinking?"> </textarea>
        <input type="text" placeholder="Tags" name="tags" />
        <button type="submit" class="btn">Post</button>
      </form>
    </div>
  </body>
</html>
