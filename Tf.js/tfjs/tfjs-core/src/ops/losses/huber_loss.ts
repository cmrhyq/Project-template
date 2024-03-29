/**
 * @license
 * Copyright 2020 Google LLC. All Rights Reserved.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * =============================================================================
 */

import {Tensor} from '../../tensor';
import {convertToTensor} from '../../tensor_util_env';
import {TensorLike} from '../../types';
import {assertShapesMatch} from '../../util';
import {abs} from '../abs';
import {add} from '../add';
import {Reduction} from '../loss_ops_utils';
import {minimum} from '../minimum';
import {mul} from '../mul';
import {op} from '../operation';
import {scalar} from '../scalar';
import {square} from '../square';
import {sub} from '../sub';

import {computeWeightedLoss} from './compute_weighted_loss';

/**
 * Computes the Huber loss between two tensors.
 *
 * @param labels The ground truth output tensor, same dimensions as
 *    'predictions'.
 * @param predictions The predicted outputs.
 * @param weights Tensor whose rank is either 0, or the same rank as
 *    `labels`, and must be broadcastable to `labels` (i.e., all dimensions
 *    must be either `1`, or the same as the corresponding `losses`
 *    dimension).
 * @param delta Point where Huber loss changes from quadratic to linear.
 * @param reduction Type of reduction to apply to loss. Should be of type
 *    `Reduction`.
 *
 * @doc {heading: 'Training', subheading: 'Losses', namespace: 'losses'}
 */
function huberLoss_<T extends Tensor, O extends Tensor>(
    labels: T|TensorLike, predictions: T|TensorLike,
    weights?: Tensor|TensorLike, delta = 1.0,
    reduction = Reduction.SUM_BY_NONZERO_WEIGHTS): O {
  const $labels = convertToTensor(labels, 'labels', 'huberLoss');
  const $predictions = convertToTensor(predictions, 'predictions', 'huberLoss');
  let $weights: Tensor = null;
  if (weights != null) {
    $weights = convertToTensor(weights, 'weights', 'huberLoss');
  }
  assertShapesMatch($labels.shape, $predictions.shape, 'Error in huberLoss: ');

  const deltaScalar = scalar(delta);
  const error = abs(sub($predictions, $labels));
  const quadratic = minimum(error, deltaScalar);
  const linear = sub(error, quadratic);

  const losses =
      add(mul(scalar(0.5), square(quadratic)), mul(deltaScalar, linear));
  return computeWeightedLoss(losses, $weights, reduction);
}
export const huberLoss = op({huberLoss_});
