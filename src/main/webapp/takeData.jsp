<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Fill Details</title>
    <link rel="stylesheet" href="css/takeData.css" />
  </head>
  <body>
    <nav>
      <h1>Tweeter</h1>
    </nav>

    <div class="container">
      <!-- Name, Bio, Picture, Location, DOJ -->
      <form method = "POST" action = "UserDetail">
        <h1>Fill Your Profile Details</h1>
        <input type="text" placeholder="Name" name="name" />
        <input type="text" placeholder="Bio" name="bio" />
        <div class="imageChoose">
          <h4>Upload your Image</h4>
          <input type="file" class="file" name="image" accept="image/*" />
        </div>
        <input type="text" placeholder="Location" name="location" />
        <button type="submit" class="btn">Submit</button>
      </form>
    </div>
  </body>
</html>
