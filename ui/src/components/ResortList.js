import {Divider, List, ListItem, ListItemText, makeStyles, Typography} from "@material-ui/core";
import MapIcon from '@material-ui/icons/Map';
import PublicIcon from '@material-ui/icons/Public';
import Sun from '../images/001-sun.svg';
import Cloud from '../images/002-cloud.svg';
import Rain from '../images/003-rain.svg';
import Cloudy from '../images/004-cloudy.svg';
import Snow from '../images/005-snowflake.svg';

const useStyles = makeStyles({
    resortCardTitle: {
        fontSize: 20,
        padding: '5px 0px',
    },
    resortCardLink: {
        fontSize: 12,
        color: '#0070AF',
        paddingRight: 30
    },
    resortCardLinkIcon: {
        width: 22,
        color: '#0070AF',
        position: 'relative',
        top: 9,
        padding: '0px 5px'
    },
    resortCardTopMiniText: {
        fontSize: 10,
        color: '#6F6F6F',
        position: 'absolute',
        top: 20,
        right: 15,
    },
    resortCardBottomMiniText: {
        fontSize: 10,
        color: '#6F6F6F',
        position: 'absolute',
        top: 115,
        right: 35,
    },
    resortCardMiniText: {
        fontSize: 10,
        color: '#6F6F6F',
    },
    weatherIcon: {
        position: 'absolute',
        right: 20,
        top: 55,
        fontSize: 55,
    },
    slopeLine: {
        borderTopWidth: 4,
        borderTopStyle: 'solid',
        margin: '5px 0px',
    },
});

function ResortList(props) {
    const classes = useStyles();
    const slopeLineWidth = 250;

    const getWeatherIcon = (weather) => {
        console.log(weather)
        switch (weather) {
            case 'Clear':
                return Sun;
            case 'Clouds':
                return Cloud;
            case 'Rain':
                return Rain;
            case 'Thunderstorm':
                return Rain;
            case 'Drizzle':
                return Rain;
            case 'Atmosphere':
                return Cloudy;
            case 'Snow':
                return Snow;
            default:
                return Sun;
        }
    }

    const getSlopeLengths = (resort) => {
        const sum = resort.slopes.easy + resort.slopes.medium + resort.slopes.hard;
        const easy = resort.slopes.easy ? (resort.slopes.easy / sum) * slopeLineWidth : 0;
        const medium = resort.slopes.medium ? (resort.slopes.medium / sum) * slopeLineWidth : 0;
        const hard = resort.slopes.hard ? (resort.slopes.hard / sum) * slopeLineWidth : 0;
        return {easy: easy, medium: medium, hard: hard, total: sum};
    }

    return (
        <List>
            {props.resorts && props.resorts.length > 0 ?
                (props.resorts.map((resort) =>
                    <div key={resort.id}>
                        <ListItem alignItems="flex-start" key={resort.id}>
                            <ListItemText>
                                <div className={classes.resortCardTitle}>
                                    <div className={classes.resortCardMiniText}>
                                        {resort.distance.toFixed(0)}km
                                    </div>
                                    {resort.name}
                                </div>
                                <img src={getWeatherIcon(resort.weather.outlook)} height='50px' width='50px'
                                     className={classes.weatherIcon}/>
                                <Typography className={classes.resortCardBottomMiniText}>{resort.weather.temperature.toFixed(0)}ºC</Typography>
                                <Typography className={classes.resortCardMiniText}>{getSlopeLengths(resort).total} km downhill runs</Typography>
                                <div style={{display: 'flex'}}>
                                    <div className={classes.slopeLine}
                                         style={{borderTopColor: '#0070AF', width: getSlopeLengths(resort).easy}}/>
                                    <div className={classes.slopeLine}
                                         style={{borderTopColor: '#CD0000', width: getSlopeLengths(resort).medium}}/>
                                    <div className={classes.slopeLine}
                                         style={{borderTopColor: '#000000', width: getSlopeLengths(resort).hard}}/>
                                </div>
                                <Typography className={classes.resortCardMiniText}>Lifts: 4 Gondolas, 8 Chairlifts, 10
                                    Surface Lifts</Typography>
                                <Typography>
                                    <MapIcon className={classes.resortCardLinkIcon}/>
                                    <a className={classes.resortCardLink} href={resort.image} target='_blank'>SkiMap</a>
                                    <PublicIcon className={classes.resortCardLinkIcon}/>
                                    <a className={classes.resortCardLink} href={resort.website}
                                       target='_blank'>Website</a>
                                </Typography>
                            </ListItemText>
                        </ListItem>
                        <Divider/>
                    </div>
                )) : <p style={{textAlign: 'center'}}>No results</p>}
        </List>
    );

}

export default ResortList;