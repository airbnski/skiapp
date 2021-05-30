// --- Imports --- //
import React from "react";
import ReactDOM from "react-dom";
// --- Material Ui Imports --- //
import { makeStyles } from "@material-ui/core";
import Typography from "@material-ui/core/Typography";
import Container from "@material-ui/core/Container";
import Button from "@material-ui/core/Button";
import Card from "@material-ui/core/Card";
import CardActionArea from "@material-ui/core/CardActionArea";
import CardActions from "@material-ui/core/CardActions";
import CardContent from "@material-ui/core/CardContent";
import CardMedia from "@material-ui/core/CardMedia";
import withStyles from "@material-ui/core/styles/withStyles";
import Box from "@material-ui/core/Box";
import Snowfall from "react-snowfall";
import skiImage from "../images/ski-image.jpg";
import weatherImg from "../images/weather.png";
import dockerimg from "../images/docker.png";
import gitimg from "../images/github.png";
import cicdimg from "../images/cicd.png";

import skimapImg from "../images/skimap.jpg";
import mainImg from "../resources/zermatt.svg";
import {Link} from "react-router-dom";


export const FiCard = withStyles({
  root: {
    position: "relative",
  },
})(Card);

export const FiCardActionArea = withStyles({
  root: {
    position: "relative",
  },
})(CardActionArea);

export const FiCardActions = withStyles({
  root: {
    position: "relative",
  },
})(CardActions);

export const FiCardContent = withStyles({
  root: {
    position: "relative",
    backgroundColor: "transparent",
  },
})(CardContent);

export const FiCardMedia = withStyles({
  root: {
    position: "absolute",
    top: 0,
    right: 0,
    height: "100%",
    width: "100%",
  },
})(CardMedia);

const useStyles = makeStyles({
  col: {
    display: "flex",
    flexDirection: "column",
    justifyContent: "center"
  },

  container: {
    display: "flex",
    flexDirection: "column",
    alignItems: "center",
    justifyContent: "center",
  },
  /**
   * Max Card with for demo
   * same values used in Material-Ui Card Demos
   */
  card: {
    maxWidth: 345,
    borderRadius: ".5rem",
    height: 175,
    margin: ".25rem"
    
  },
  card2: {
    width: 345,
    borderRadius: ".5rem",
    margin: ".25rem"
    
  },

  bgCard: {
    height: "60vh",
    borderRadius: ".5rem"
  },

  /**
   * Applied to Orginal Card demo
   * Same vale used in Material-ui Card Demos
   */
  media: {
    height: 140,
  },

  /**
   * Demo stlying to inclrease text visibility
   * May verry on implementation
   */
  fiCardContent: {
    color: "#ffffff",
    backgroundColor: "rgba(0,0,0,.60)",
    height: "100%"
  },

  fiCardContent2: {
    color: "#ffffff",
    backgroundColor: "rgba(0,0,0,.60)",

  },

  fiCardContentTextSecondary: {
    color: "#fff",
    fontSize: 16,
    fontWeight: 400,
  },

  titleCardText: {
    fontFamily: 'Reem Kufi',
    fontSize: 36,
    fontWeight: 400,
    letterSpacing: '0.2em',
    margin: 5,
    //color: "#fff"
},
subtitleText: {
    fontFamily: 'Reem Kufi',
    fontSize: 26,
    fontWeight: 400,
    letterSpacing: '0em',
    margin: 5,
    //color: "#fff"
},
colorButton: {
    margin: 20,
    fontWeight: 500,
    backgroundColor: '#FFCE1F',
    '&:hover': {
        backgroundColor: '#B89000',
    },
},
heading:{
    display: "flex",
    flexDirection: "column",
    alignItems: "center"
},featureRow: {
    display: "flex",
    justifyContent: "space-around",
    marginBottom: "2rem"
}

});

function HomePage() {
  const classes = useStyles();

  return (
    <div s>
    

      <div className={classes.col}>
        <FiCard className={classes.bgCard}>
          <FiCardMedia
            media="picture"
            alt="Contemplative Reptile"
            image={mainImg}
            title="Contemplative Reptile"
          >
            <Snowfall // Applied to the c
              // Controls the number of snowflakes that are created (default 150)
              snowflakeCount={200}
            />
          </FiCardMedia>
        </FiCard>
   
   
        <div className={classes.heading}>
            <h2 className={classes.titleCardText}>AirBNSki</h2>
            <p className={classes.subtitleText}>Discover your next adventure</p>
            <Link to="/map" style={{textDecoration: 'none'}}>
                    {/*<KeyboardArrowDownIcon style={{fontSize: '5.5rem'}}/>*/}
                    <Button className={classes.colorButton}>To The App</Button>
                </Link>
        </div>

        <div className={classes.featureRow}>
        <FiCard className={classes.card}>
            <FiCardMedia
              media="picture"
              alt="Contemplative Reptile"
              image={skiImage}
              title="Contemplative Reptile"
            />
            <FiCardContent className={classes.fiCardContent}>
              <Typography gutterBottom variant="h5" component="h2">
                Piste Information
              </Typography>
              <Typography
                variant="body2"
                className={classes.fiCardContentTextSecondary}
                component="p"
              >
                AirBNSki provides you information about pistes in a ski resort, total length in Kms according to difficulty.         
                 
              </Typography>
            </FiCardContent>
            
          </FiCard>

          <FiCard className={classes.card}>
            <FiCardMedia
              media="picture"
              alt="Contemplative Reptile"
              image={skimapImg}
              title="Contemplative Reptile"
            />
            <FiCardContent className={classes.fiCardContent}>
              <Typography gutterBottom variant="h5" component="h2">
                Ski Map
              </Typography>
              <Typography
                variant="body2"
                className={classes.fiCardContentTextSecondary}
                component="p"
              >
                AirBNSki provides you latest ski resort maps with links to the webshops to purchase tickets.
              </Typography>
            </FiCardContent>
           
          </FiCard>

          <FiCard className={classes.card}>
            <FiCardMedia
              media="picture"
              alt="Contemplative Reptile"
              image={weatherImg}
              title="Contemplative Reptile"
            />
            <FiCardContent className={classes.fiCardContent}>
              <Typography gutterBottom variant="h5" component="h2">
                Weather Report
              </Typography>
              <Typography
                variant="body2"
                className={classes.fiCardContentTextSecondary}
                component="p"
              >
                AirBNSki provides you latest weather reports for the ski resorts with the ability to search using filters.
              </Typography>
            </FiCardContent>
           
          </FiCard>
        </div>
        <div className={classes.featureRow}>
        <FiCard className={classes.card2}>
          <FiCardMedia
            media="picture"
            alt="Contemplative Reptile"
            image={gitimg}
            title="Contemplative Reptile"
          />
          <FiCardContent className={classes.fiCardContent2}>
            <Typography gutterBottom variant="h5" component="h2">
              Github
            </Typography>
            <Typography
              variant="body2"
              className={classes.fiCardContentTextSecondary}
              component="p"
            >
              Check out our code reporsitories and wiki here.
            </Typography>
          </FiCardContent>
          <FiCardActions className={classes.fiCardContent2}>
            <Button size="small" color="inherit" variant="outlined" href="https://github.com/airbnski/skiapp">
              Visit
            </Button>
          </FiCardActions>
        </FiCard>
        <FiCard className={classes.card2}>
          <FiCardMedia
            media="picture"
            alt="Contemplative Reptile"
            image={dockerimg}
            title="Contemplative Reptile"
          />
          <FiCardContent className={classes.fiCardContent2}>
            <Typography gutterBottom variant="h5" component="h2">
              DockerHub
            </Typography>
            <Typography
              variant="body2"
              className={classes.fiCardContentTextSecondary}
              component="p"
            >
              Check out our published docker images here.
            </Typography>
          </FiCardContent>
          <FiCardActions className={classes.fiCardContent2}>
            <Button size="small" color="inherit" variant="outlined" href="https://hub.docker.com/u/airbnski">
          Visit
            </Button>
          </FiCardActions>
        </FiCard>
        <FiCard className={classes.card2}>
          <FiCardMedia
            media="picture"
            alt="Contemplative Reptile"
            image={cicdimg}
            title="Contemplative Reptile"
          />
          <FiCardContent className={classes.fiCardContent2}>
            <Typography gutterBottom variant="h5" component="h2">
              CI CD Infrastructure
            </Typography>
            <Typography
              variant="body2"
              className={classes.fiCardContentTextSecondary}
              component="p"
            >
              Check out our CI/CD & development infrastructure here.
            </Typography>
          </FiCardContent>
          <FiCardActions className={classes.fiCardContent2}>
            <Button size="small" color="inherit" variant="outlined" href="http://34.65.190.202:8080">
Visit            </Button>
          </FiCardActions>
        </FiCard>
        </div>
      
   
      </div>
    </div>
  );
}

export default HomePage;
