import {AppBar, Button, makeStyles, Toolbar, Typography} from "@material-ui/core";
import {Link} from "react-router-dom";

const useStyles = makeStyles({
    toolbar: {
        background: '#204A70',
        color: 'white',
        height: 60
    },
    nav: {
        display: 'flex',
        flexDirection: 'row-reverse',
        width: '100%',
        alignItems: 'flex-end'
    },
    button: {
        textDecoration: 'none', color: 'white'
    }
});

export default function TopAppBar() {
    const classes = useStyles();

    return (
        <AppBar position="static">
            <Toolbar className={classes.toolbar}>
                <Typography variant="h6">
                <Link to="/">
                        <Button className={classes.button}>AirBNSki</Button>
                    </Link>
                    
                    
                </Typography>
                <div className={classes.nav}>
                    <Link to="/map">
                        <Button className={classes.button}>Map</Button>
                    </Link>
                    <Link to="/">
                        <Button className={classes.button}>Home</Button>
                    </Link>
                </div>
            </Toolbar>
        </AppBar>
    );

}