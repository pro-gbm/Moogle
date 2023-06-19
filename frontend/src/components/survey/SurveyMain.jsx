/** @jsxImportSource @emotion/react */
import { css } from '@emotion/react';

import Button from '../common/Button';
import Option from './Option';
import axios from 'axios';
import { useEffect, useState } from 'react';
import { CONST, URL } from '../../constants';

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
    maxHeight: '65%',
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

  const getTestApi = async (param) => {
    try {
      console.log('파라미터', param);
      let res = await axios.get(`${URL}/api/question/2`);
      console.log('결과는', res);
    } catch (err) {
      console.error(err);
      throw err;
    }
  };

  const getQuestionApi = async (questionNum) => {
    try {
      console.log('몇 번째 질문을 호출할 거임?', questionNum);
      let res = await axios.get(`${URL}/api/question/${questionNum}`);
      console.log('결과는', res);
      return res;
    } catch (err) {
      console.error(err);
      throw err;
    }
  };

  useEffect(() => {
    getQuestionApi(1).then((res) => {
      setQData({
        qId: 1,
        qTitle: CONST.TITLES[0],
        qDescription: CONST.DESCRIPTIONS[0],
        qOption: [...res.data.data],
      });
    });
  }, []);

  return (
    <div css={surveyMain}>
      <div
        className="title"
        onClick={() => {
          let param = {};
          getTestApi(param);
        }}
      >
        {qData.qId}. {qData.qTitle}
      </div>
      <div className="description">{qData.qDescription}</div>
      <div className="options">
        {qData.qOption.map((option, index) => (
          <Option key={`${option.id}-${index}`} data={option.name} />
        ))}
      </div>
      <div css={buttonArea}>
        {/* <img
          src="https://image.tmdb.org/t/p/original/3FyO7Z8WigeCQsUpW4B1x3qfmFx.jpg"
          alt="헬렌.."
          height="100px"
          width="100px"
        /> */}

        <div
          onClick={() => {
            if (currentQuestion > 1) {
              setCurrentQuestion(currentQuestion - 1);
              passCurrentQuestion(currentQuestion - 1);
            }
          }}
        >
          <Button
            color="default"
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
          <Button
            color="default"
            size="large"
            value="Next"
            variant="filled"
            iconPosition="back"
          />
        </div>
      </div>
    </div>
  );
}

export default SurveyMain;
