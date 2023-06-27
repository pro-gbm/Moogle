/** @jsxImportSource @emotion/react */
import { css } from '@emotion/react';

import Button from '../common/Button';
import Option from './Option';
import axios from 'axios';
import { useEffect, useState } from 'react';
import { CONST, URL } from '../../constants';
import { Link } from 'react-router-dom';

const surveyMain = css({
  width: '80%',
  height: `calc(100vh - ${CONST.HEADERHEIGHT}px - ${CONST.FOOTERHEIGHT}px)`,
  marginTop: '50px',
  display: 'flex',
  flexDirection: 'column',
  justifyContent: 'space-between',
  color: '#FFF',
  '.title': {
    fontSize: '2rem',
    marginLeft: '15%',
    marginRight: '15%',
  },
  '.description': {
    marginLeft: '15%',
    marginRight: '15%',
    marginBottom: '30px',
  },
  '.options': {
    minHeight: '50vh',
    maxHeight: '50vh',
    overflow: 'scroll',
  },
});

const buttonArea = css({
  height: '7%',
  marginLeft: '15%',
  marginRight: '15%',
  display: 'flex',
  justifyContent: 'space-around',
  alignItems: 'center',
  '@media (max-width: 800px)': {
    flexDirection: 'column',
  },
});

function SurveyMain(props) {
  const { passCurrentQuestion } = props;
  const [qData, setQData] = useState({
    qId: 0,
    qTitle: '',
    qDescription: '',
    qOption: [],
  });
  const [currentQuestion, setCurrentQuestion] = useState(1);
  const [answers, setAnswers] = useState({
    genres: [],
    movies: [],
    directors: [],
    actors: [],
  });

  const getQuestionApi = async (questionNum) => {
    try {
      let res = await axios.get(`${URL}/api/question/${questionNum}`);
      console.log('결과는', res);
      return res;
    } catch (err) {
      console.error(err);
      throw err;
    }
  };

  const onClickOption = (paramOption, paramFlag) => {
    switch (currentQuestion) {
      case 1:
        if (paramFlag) {
          setAnswers({ ...answers, genres: [...answers.genres, paramOption] });
        } else {
          let filtered = [...answers.genres].filter(
            (element) => element !== paramOption
          );
          setAnswers({ ...answers, genres: filtered });
        }
        break;
      case 2:
        if (paramFlag) {
          setAnswers({ ...answers, movies: [...answers.movies, paramOption] });
        } else {
          let filtered = [...answers.movies].filter(
            (element) => element !== paramOption
          );
          setAnswers({ ...answers, movies: filtered });
        }
        break;
      case 3:
        if (paramFlag) {
          setAnswers({
            ...answers,
            directors: [...answers.directors, paramOption],
          });
        } else {
          let filtered = [...answers.directors].filter(
            (element) => element !== paramOption
          );
          setAnswers({ ...answers, directors: filtered });
        }
        break;
      case 4:
        if (paramFlag) {
          setAnswers({ ...answers, actors: [...answers.actors, paramOption] });
        } else {
          let filtered = [...answers.actors].filter(
            (element) => element !== paramOption
          );
          setAnswers({ ...answers, actors: filtered });
        }
        break;
      default:
        break;
    }
  };

  const figureDefaultFlag = (paramId) => {
    let returnFlag = false;

    switch (currentQuestion) {
      case 1:
        if (answers.genres.includes(paramId)) {
          returnFlag = true;
        }
        break;
      case 2:
        if (answers.movies.includes(paramId)) {
          returnFlag = true;
        }
        break;
      case 3:
        if (answers.directors.includes(paramId)) {
          returnFlag = true;
        }
        break;
      case 4:
        if (answers.actors.includes(paramId)) {
          returnFlag = true;
        }
        break;
      default:
        break;
    }
    return returnFlag;
  };

  useEffect(() => {
    if (currentQuestion > 0 && currentQuestion < 5) {
      getQuestionApi(currentQuestion).then((res) => {
        setQData({
          qId: currentQuestion,
          qTitle: CONST.TITLES[currentQuestion - 1],
          qDescription: CONST.DESCRIPTIONS[currentQuestion - 1],
          qOption: [...res.data.data],
        });
      });
    }
  }, [currentQuestion]);

  return (
    <div css={surveyMain}>
      <div
        className="title"
        onClick={() => {
          console.log('answers 결과 보자', answers);
        }}
      >
        {qData.qId}. {qData.qTitle}
      </div>
      <div className="description">{qData.qDescription}</div>
      <div className="options">
        {qData.qOption.map((option, index) => (
          <Option
            key={`${option.id}-${index}`}
            data={option}
            defaultFlag={figureDefaultFlag(option.id)}
            onClickOption={onClickOption}
          />
        ))}
      </div>
      <div css={buttonArea}>
        <div
          onClick={() => {
            if (currentQuestion > 1) {
              setCurrentQuestion(currentQuestion - 1);
              passCurrentQuestion(currentQuestion - 1);
            }
          }}
        >
          <Button
            color={currentQuestion !== 1 ? 'default' : 'disabled'}
            size="large"
            value="Prev"
            variant="filled"
            iconPosition="back"
          />
        </div>
        <div
          onClick={() => {
            if (currentQuestion < 4) {
              setCurrentQuestion(currentQuestion + 1);
              passCurrentQuestion(currentQuestion + 1);
            }
          }}
        >
          <Link
            style={{ textDecoration: 'none' }}
            to={currentQuestion === 4 && '/result'}
            state={{ answers: answers }}
          >
            <Button
              color={currentQuestion !== 4 ? 'default' : 'warning'}
              size="large"
              value="Next"
              variant="filled"
              iconPosition="back"
            />
          </Link>
        </div>
      </div>
    </div>
  );
}

export default SurveyMain;
