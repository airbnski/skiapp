import {Box, Button, Card, CardActions, CardContent, makeStyles} from "@material-ui/core";
import skiImage from "../images/ski-image.jpg";
import {Link} from "react-router-dom";

const useStyles = makeStyles({
    bg: {
        backgroundImage: `url(${skiImage})`,
        backgroundPosition: 'top',
        backgroundRepeat: 'no-repeat',
        backgroundSize: 'cover',
        width: '100%',
        height: '100vh'
    },
    titleContainer: {
        position: 'absolute',
        right: '15%',
        top: '65%',
        width: '70%',
        color: 'black',
        display: 'flex',
        alignItems: 'center',
        flexDirection: 'column',
    },
    titleCard: {
        height: 210,
        blend: 'pass-through',
        background: 'rgba(119, 151, 191, 0.75)',
        display: 'flex',
        alignItems: 'center',
        flexDirection: 'column',
    },
    titleCardText: {
        fontFamily: 'Reem Kufi',
        fontSize: 96,
        fontWeight: 400,
        letterSpacing: '0.2em',
        margin: 10,
    },
    subtitleText: {
        fontFamily: 'Reem Kufi',
        fontSize: 36,
        fontWeight: 400,
        letterSpacing: '0em',
        textAlign: 'center',
        margin: 10,
    },
    colorButton: {
        margin: 20,
        fontWeight: 500,
        backgroundColor: 'white',
        '&:hover': {
            backgroundColor: 'grey',
        },
    },
});

function HomePage() {
    const classes = useStyles();

    return (
        <Box className={classes.bg}>
            <div className={classes.titleContainer}>
                <Card className={classes.titleCard}>
                    <CardContent>
                        <h2 className={classes.titleCardText}>Welcome to AirBNSki</h2>
                        <p className={classes.subtitleText}>discover your next adventure</p>
                    </CardContent>
                    <CardActions>
                        <Link to="/map" style={{textDecoration: 'none'}}>
                            <Button className={classes.mapButton}>
                                See Map
                            </Button>
                        </Link>
                    </CardActions>
                </Card>
                <Link to="/map" style={{textDecoration: 'none'}}>
                    {/*<KeyboardArrowDownIcon style={{fontSize: '5.5rem'}}/>*/}
                    <Button className={classes.colorButton}>Interactive Map</Button>
                </Link>
            </div>
        </Box>
    );
}

export default HomePage;