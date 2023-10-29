import React from "react";
import { Client } from "@petfinder/petfinder-js";
import Grid from "@mui/material/Grid";
import Paper from "@mui/material/Paper";
import Typography from "@mui/material/Typography";

const client = new Client({
  apiKey: "d54LZiYzaZvUPTWhvHmZ0FWQbEfxcbbN00evADHigyovLuRush",
  secret: "xbbIliPyIHncva3fnA6l17Igs4o5m9mT5gSJ1czi"
});

const blockStyle = {
  padding: "20px",
  display: "flex",
  flexDirection: "column",
  alignItems: "center",
  textAlign: "center"
};

const textBlockStyle = {
  backgroundColor: "#FFA1E5",
  padding: "10px",
  width: "100%",
  boxSizing: "border-box"
};

const textStyle = {
  color: "white"
};

class Adoption extends React.Component {
  constructor(props) {
    super(props);
    //官网：Your current access allows 1,000 requests/day, with a rate limit of 50 requests/second. 
    this.state = {
      animalResults: []
    };
    client.animal
      .search({
        limit: 100
      })
      .then((response) => {
        const res = response.data.animals.filter((animal) => {
          return animal.photos.length > 0 && animal.url;
          //但是Response里很多都没有图片就显示不了
        });
        return res;
      })
      .then((data) => {
        this.setState({ animalResults: data });
        console.log(this.state.animalResults);
      })
      .catch((error) => {
        console.log(error);
      });
  }

  render() {
    return (
      <div>
        <Typography
          style={{ color: '#C932C3' }}
          variant="h3"
          fontWeight="bold"
          marginTop={5}>
          Pet Adoption
        </Typography>
        <br></br>
        <Grid container spacing={2}>
          {this.state.animalResults.map((animal) => (
            <Grid item xs={12} sm={6} md={3} key={animal.id}>
              <Paper elevation={3} style={blockStyle}>
                <a href={animal.url} target="_blank" rel="noopener noreferrer">
                  <img src={animal.photos[0].small} alt={animal.name} />
                  <div style={textBlockStyle}>
                    <Typography variant="h6" style={textStyle}>
                      {animal.name}
                    </Typography>
                  </div>
                </a>
              </Paper>
            </Grid>
          ))}
        </Grid>
      </div>
    );
  }
}

export default Adoption;
